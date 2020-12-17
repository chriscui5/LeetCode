/**
 * @author:yixiaolan
 * @date:Created in 2020/12/3
 * @description:
 * @version:1.0
 */
public class Solution {
    public int countPrimes(int n) {
        int ans = 0;
        for (int i=2 ; i<n ; i++){
            ans += isPrime(i) ? 1:0;
        }
        return ans;
    }

    public boolean isPrime(int x){
        for (int i=2; i*i<=x ; i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
}
