/**
 * @author:yixiaolan
 * @date:Created in 2020/10/8
 * @description:
 * @version:1.0
 */
public class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
