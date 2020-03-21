import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7},7);
        System.out.println(res);

    }
    public static List<List<Integer>> res =  new LinkedList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        // 排序的原因是在回溯的时候比较容易剪枝
        Arrays.sort(candidates);
        // 套用上面的公式，candidates是指选择列表，target用来判断是否结束以及用于剪枝
        // track则是路径，即已经做出的选择
        backtrack(candidates, target, track);
        return res;
    }

    private static void backtrack(int[] candidates, int target, LinkedList<Integer> track) {
        //先判断结束条件
        if (target < 0) return;
        if (target == 0){
            // 当target等于0的时候，将路径加入到结果列表中
            res.add(new LinkedList<>(track));
            return;
        }
        // 遍历选择列表，这里没有去重
        //下面会设置start，每次递归的时候只在candidates中当前及之后的数字中选择。
        for(int i = 0;i < candidates.length;i++){
            // 这就是排序的好处，可以直接这样剪枝，否则还得遍历
            if(target < candidates[i]) break;
            track.add(candidates[i]);
            backtrack(candidates,target-candidates[i],track);
            track.removeLast();
        }
    }

}
