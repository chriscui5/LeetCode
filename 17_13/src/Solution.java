import java.util.HashSet;
import java.util.Set;

/**
 * @author:yixiaolan
 * @date:Created in 2020/7/9
 * @description:
 * @version:1.0
 */
public class Solution {
    public int respace(String[] dictionary, String sentence) {
        Set<String> dic = new HashSet<>();
        for(String str: dictionary) dic.add(str);

        int n = sentence.length();
        //dp[i]表示sentence前i个字符所得结果
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1]+1;  //先假设当前字符作为单词不在字典中
            for(int j=0; j<i; j++){
                if(dic.contains(sentence.substring(j,i))){
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];
    }



}
