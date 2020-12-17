/**
 * @author:yixiaolan
 * @date:Created in 2020/8/17
 * @description:
 * @version:1.0
 */
public class Solution {
    public String longestPalindrome(String s) {
        int length=s.length();
        int[][] dp=new int[length][length];
        String ans=new String();
        int flag;
        for (int l = 0; l < length; ++l) {
            for (int i = 0; i + l < length; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = 1;
                }
                else if (l == 1) {
                    if(s.charAt(i)==s.charAt(j)){
                        flag=1;
                    }
                    else {
                        flag=0;
                    }
                    dp[i][j]=flag;
                }
                else {
                    if(s.charAt(i)==s.charAt(j)&& dp[i + 1][j - 1]>=1){
                        flag=1;
                    }
                    else {
                        flag=0;
                    }
                    dp[i][j] = flag;
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substr(i, l + 1);
                }
            }
        }
        return ans;
    }
}
