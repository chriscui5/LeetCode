import java.util.Stack;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/29
 * @description:
 * @version:1.0
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int prevSum){
        if(root==null){
            return 0;
        }
        int sum=prevSum*10+root.val;
        if(root.left==null&&root.right==null){
            return sum;
        }
        else {
            return dfs(root.left, sum)+ dfs(root.right,sum);
        }
    }
}
