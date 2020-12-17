import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/16
 * @description:
 * @version:1.0
 */
//dp[i]表示能否跳到第i个结点上
public class Solution2 {
    public boolean canJump(int[] nums) {
        if(nums==null){
            return false;
        }
        int len=nums.length;
        boolean[] dp=new boolean[len];
        dp[0]=true;

        for (int i=1;i<len;i++){
            for (int j=0;j<i;j++){
                if(dp[j]&&nums[j]+j>=i){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len-1];
    }
}
