import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/19
 * @description:
 * @version:1.0
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        boolean[] isUsed= new boolean[nums.length];
        Arrays.sort(nums);


        dfs(res,path,nums,isUsed,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path,int[] nums,boolean[] isUsed,int idx) {

        if (idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }


        for(int i=0;i<nums.length;i++){

            if (isUsed[i] || (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1])) {
                continue;
            }

            path.add(nums[i]);
            isUsed[i]=true;
            dfs(res, path, nums, isUsed, idx+1);
            isUsed[i]=false;
            path.remove(idx);

        }


    }
}
