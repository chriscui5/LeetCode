import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/11
 * @description:
 * @version:1.0
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> path, int nums, int start, int target) {
        if (path.size() == nums && target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<=9;i++){
            path.add(i);
            dfs(res,path,nums,start+1,target-i);
            path.remove(path.size()-1);
        }


    }
}

