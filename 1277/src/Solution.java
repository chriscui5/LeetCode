/**
 * @author:yixiaolan
 * @date:Created in 2020/10/30
 * @description:
 * @version:1.0
 */
public class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        int ans=0;
        for (int i=0 ; i<m; i++){
            ans = ans + (dp[i][0]=matrix[i][0]);
        }
        for (int j=0 ; j<n; j++){
            ans = ans + (dp[0][j]=matrix[0][j]);
        }
        if (matrix[0][0] == 1) {
            ans--;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }
}
