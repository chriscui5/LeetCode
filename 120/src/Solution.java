import java.util.List;
import java.util.Map;

/**
 * @author:yixiaolan
 * @date:Created in 2020/4/20
 * @description:
 * @version:1.0
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp=new int[size][size];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<size;i++){
            for(int j=0;j<=i;j++){
                int b=triangle.get(i).get(j);
                if(j==0){
                    dp[i][j]=dp[i-1][j]+b;
                }
                else if(j==i){
                    dp[i][j]=dp[i-1][j-1]+b;
                }
                else {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+b;
                }
            }
        }
        int min=dp[size-1][0];
        for (int i=1;i<size;i++){
            min= Math.min(min,dp[size-1][i]);
        }
        return min;
    }
}
