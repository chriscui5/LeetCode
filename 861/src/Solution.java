import java.util.Map;

/**
 * @author:yixiaolan
 * @date:Created in 2020/12/7
 * @description:
 * @version:1.0
 */
public class Solution {
    public int matrixScore(int[][] A){
        int m = A.length;
        int n = A[0].length;

        int result = 0;

        //进行行反转
        for (int i = 0 ; i<m ;i++){
            if(A[i][0] ==  0){
                for (int j = 0 ; j<n ;j++){
                    A[i][j] ^=1;
                }
            }
        }

        //进行列翻转 保证1最多
        for (int j = 0 ; j < n ;j++){
            int cnt =0 ;
            for (int i = 0 ; i<m ;i++){
                cnt += A[i][j];
            }
            result += Math.max(cnt,m-cnt)*(1<<(n-j-1));
        }
        return result;
    }
}
