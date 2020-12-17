import java.util.*;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/10
 * @description:
 * @version:1.0
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);    // 剪枝：处理 “重复结果问题”
        int len=candidates.length;
        List<List<Integer>> res=new ArrayList<>();
        if(len==0){
            return null;
        }
        Deque<Integer> path=new ArrayDeque<>();
        dfs(candidates,0,len,target,path,res);
        return res;
    }

    private void dfs(int[] candidates, int start, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if(target==0){
            res.add(new ArrayList<>(path));
        }
        else if(target<0){
            return;
        }
        else {
            for (int i = start; i < len; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {  // 剪枝 + 处理 “重复结果问题”
                    continue;
                }

                path.addLast(candidates[i]);

                // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
                dfs(candidates, start+1, len, target - candidates[i], path, res);

                // 状态重置
                path.removeLast();
            }
        }

    }

}
