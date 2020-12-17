/**
 * @author:yixiaolan
 * @date:Created in 2020/9/3
 * @description:
 * @version:1.0
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int len=A.length;
        int[] dp=new int[len];
        int sum=0;
        for (int i=2;i<len;i++){
            if((A[i]-A[i-1])==(A[i-1]-A[i-2])){
                dp[i]=dp[i-1]+1;
                sum+=dp[i];
            }

        }
        return sum;
    }
}
