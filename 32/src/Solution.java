import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author:yixiaolan
 * @date:Created in 2020/7/4
 * @description:
 * @version:1.0
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> que=new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                que.push(i);
            }
            else {
                que.pop();
                if(!que.isEmpty()){
                    maxans=maxans+2;
                }
            }
        }

        return maxans;
    }
}
