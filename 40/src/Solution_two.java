/**
 * @author:yixiaolan
 * @date:Created in 2020/9/10
 * @description:
 * @version:1.0
 */
public class Solution_two {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length <= 0 || target <= 0) {
            return null;
        }

        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);    // 剪枝：处理 “重复结果问题”
        Deque<Integer> curPath = new ArrayDeque<>();
        dfs(candidates, 0, target, curPath, 0, results);

        return results;
    }

    private void dfs(int[] candidates, int index, int target, Deque<Integer> curPath, int curValue, List<List<Integer>> results) {
        if (curValue == target) {   // 满足条件，存储当前结果，并结束本轮递归
            results.add(new ArrayList<>(curPath));
            return;
        }

        if (curValue > target) {    // 当前结果 大于 目标值，结束本轮递归
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {  // 剪枝 + 处理 “重复结果问题”
                continue;
            }

            int curCandidate = candidates[i];

            curPath.addLast(curCandidate);
            dfs(candidates, i + 1, target, curPath, curValue + curCandidate, results);
            curPath.removeLast();
        }
    }


}
