/**
 * @author:yixiaolan
 * @date:Created in 2020/12/13
 * @description:
 * @version:1.0
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return len;
        }
        int prevdiff = nums[1] - nums[0];
        int ret = prevdiff != 0 ? 2:1;
        for (int i =2 ; i<len ;i++){
            int diff = nums[i] - nums[i-1];
            if((diff>0 && prevdiff<=0)||(diff< 0 && prevdiff>=0)){
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }
}
