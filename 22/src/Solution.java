import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author:yixiaolan
 * @date:Created in 2020/11/14
 * @description:
 * @version:1.0
 */
public class Solution {

    public List<String> res;

    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        if (n==0){
            return res;
        }
        dfs("",n,n);
        return res;
    }

    private void dfs(String curStr, int left, int right) {
        if( left == 0 && right == 0){
            res.add(curStr);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(curStr + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(curStr + ")", left, right - 1);
        }
    }
}
