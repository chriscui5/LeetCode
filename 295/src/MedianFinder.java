import java.util.PriorityQueue;

/**
 * @author:yixiaolan
 * @date:Created in 2020/12/11
 * @description:
 * @version:1.0
 */
public class MedianFinder {
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    /** initialize your data structure here. */
    public MedianFinder() {
        large = new PriorityQueue<>();//小数在下 大数在上
        small = new PriorityQueue<>((a,b)->{
            return b-a;
        }); // 大数在下 小树在上
    }

    public void addNum(int num) {
        if(small.size() >= large.size()){
            small.offer(num);
            large.offer(small.poll());
        }
        else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    //有缺陷的代码实现
    public double findMedian() {
        //后文实现
        if(large.size() < small.size()){
            return small.peek();
        }
        else if(large.size() > small.size()){
            return large.peek();
        }
        return (large.peek()+small.peek())/2.0;
    }
}
