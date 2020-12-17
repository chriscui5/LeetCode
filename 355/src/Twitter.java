import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import javax.jws.soap.SOAPBinding;
import java.util.*;

/**
 * @author:yixiaolan
 * @date:Created in 2020/12/13
 * @description:
 * @version:1.0
 */
public class Twitter {
    static int timeStamp = 0;

    //一个映射将UserId和User对象对应起来
    private HashMap<Integer, User> userMap = new HashMap<>();

    public Twitter(){

    }

    //user 发布一条tweet动态
    public void postTweet(int userId,int tweetId){
        //若userId不存在，则新建
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    //返回该user关注的人（包括他自己）最新的动态id
    //最多10条 而且这些动态必须按照从新到旧的时间顺序排序
    public List<Integer> getNewsFeed(int userId){
        //返回的答案
        List<Integer> res = new ArrayList<>();
        //如果列表为空 则直接返回
        if(!userMap.containsKey(userId)){
            return res;
        }
        //关注列表的用户 Id
        Set<Integer> users = userMap.get(userId).followed;
        //自动通过time属性从大到小顺序 容量为users的大小
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
                users.size(),
                (a,b)->(b.time-a.time)
        );
        //将所有链表头节点插入优先级队列
        for (int id:users){
            Tweet twt = userMap.get(id).head;
            if(twt == null){
                continue;
            }
            pq.add(twt);
        }
        while (!pq.isEmpty()){
            //最多返回10条就够了
            if(res.size() == 10){
                break;
            }
            //弹出time值最大的（最近发表的）
            Tweet twt = pq.poll();
            res.add(twt.id);
            //将下一篇Tweet插入进行排序
            if(twt.next != null){
                pq.add(twt.next);
            }
        }
        return res;
    }

    //follower 关注 followee
    public void follow(int followerId,int followeeId){
        //若follower不存在 则新建
        if(!userMap.containsKey(followeeId)){
            User u = new User(followerId);
            userMap.put(followerId,u);
        }
        //若followee不存在 则新建
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId,u);
        }
        userMap.get(followerId).follow2(followeeId);
    }

    //follower不关注followee
    public void unfollow(int followerId, int followeeId){
        userMap.get(followerId).unfollow(followeeId);
    }

    class User{
        private int id;
        public Set<Integer> followed;
        //用户发表的推文链表头结点
        public Tweet head;
        public User(int userId){
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;
            //关注一下自己
            follow2(id);
        }
        public void follow2(int userId){
            followed.add(userId);
        }
        public void unfollow(int userId){
            //不可以取关自己
            if(userId != this.id){
                followed.remove(userId);
            }
        }
        public void post(int tweetId){
            Tweet twt = new Tweet(tweetId,timeStamp);
            timeStamp++;
            //将新建的推文 插入 链表头
            //越靠前的推文 time 值越大
            twt.next = head;
            head = twt;
        }
    }

    class Tweet{
        private int id;
        private int time;
        private Tweet next;
        //需要传入推文的内容（id)和发文时间
        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }
}
