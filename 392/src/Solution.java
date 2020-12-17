/**
 * @author:yixiaolan
 * @date:Created in 2020/7/27
 * @description:
 * @version:1.0
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public boolean isSubsequence2(String s, String t) {
        if (s.length() == 0)
            return true;
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for (int i = 0; i < t.length(); i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public boolean isSubsequence3(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            //index表示上一次查找的位置(第一次查找的时候为-1)，所以这里要从t的下标(index+1)开始查找
            index = t.indexOf(c, index + 1);
            //没找到，返回false
            if (index == -1)
                return false;
        }
        return true;
    }


}

