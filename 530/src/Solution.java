import java.util.Map;
import java.util.Stack;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/12
 * @description:
 * @version:1.0
 */
public class Solution {
    public int getMinimumDifference(TreeNode tree) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=tree;
        TreeNode prev=null;
        int min=Integer.MAX_VALUE;
        while (cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
        if (!stack.isEmpty()) {
            cur = stack.pop();
            if(prev!=null){
                min= Math.min(min,cur.val-prev.val);
            }
            prev=cur;
            cur = cur.right;
        }
        return min;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }