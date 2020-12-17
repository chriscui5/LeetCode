import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/8
 * @description:
 * @version:1.0
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        if(k<=0||n<k){
            return res;
        }
        Deque<Integer> path=new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return res;
    }

    private void dfs(int n, int k, int i, Deque<Integer> path, List<List<Integer>> res) {
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int begin=i;begin<=n;begin++){
            path.addLast(begin);
            dfs(n, k, begin+1, path, res);
            path.removeLast();
        }
    }
}
