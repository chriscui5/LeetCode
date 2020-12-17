import java.util.Arrays;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/1
 * @description:
 * @version:1.0
 */
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
      int len=nums.length;
      int[][] dp=new int[len][len];
      for (int i=0;i<len;i++){
          Arrays.fill(dp[i],Integer.MIN_VALUE);
      }
      return dfs(0,len-1,nums,dp)>=0;
    }

    public int dfs(int start,int end,int[] nums,int[][] dp){
        if(end>start){
            return 0;
        }
        if(dp[start][end]!=Integer.MIN_VALUE){
            return dp[start][end];
        }
        int LeftValue=nums[start]-dfs(start+1,end,nums,dp);
        int RightValue=nums[end]-dfs(start,end-1,nums,dp);
        dp[start][end]=Math.max(LeftValue,RightValue);
        return dp[start][end];
    }


}
