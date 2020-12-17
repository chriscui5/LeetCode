/**
 * @author:yixiaolan
 * @date:Created in 2020/9/16
 * @description:
 * @version:1.0
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int len=nums.length;
        return backTrace(nums,0,len-1);

    }

    private boolean backTrace(int[] nums, int start, int end) {
        if(start==end){
            return true;
        }
        if(start>end){
            return false;
        }
        int step=nums[start];
        for (int i=1;i<=step;i++){
            if(backTrace(nums,start+i,end)) return true;
        }
        return false;
    }
}
