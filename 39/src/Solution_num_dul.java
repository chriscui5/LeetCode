import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/9
 * @description:
 * @version:1.0
 */
public class Solution_num_dul {

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;

    }

    private void dfs(int[] candidates, int start, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }else if(target<0) {
            return;
        }
        else {
            for (int i=start;i<len;i++){
                path.addLast(candidates[i]);
                dfs(candidates,i,len,target-candidates[i],path,res);
                path.removeLast();
            }
        }
    }
}
