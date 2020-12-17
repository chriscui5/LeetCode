/**
 * @author:yixiaolan
 * @date:Created in 2020/4/23
 * @description:
 * @version:1.0
 */
class Solution {
    public int waysToChange(int n) {
        int mod = 1000000007;
        int[] vector=new int[n+1];
        int[] coins= {25,10,5,1};
        int coin;
        vector[0]=1;
        for (int i=0;i<4;i++){
            coin=coins[i];
            for (int j=coin;j<=n;j++){
                vector[j]=(vector[j]+vector[j-coin])%mod;
            }
        }
        return vector[n];
    }
}
