import java.util.Deque;
import java.util.LinkedList;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/21
 * @description:
 * @version:1.0
 */
public class Solution {
    public boolean isValidBSt(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<TreeNode>();
        TreeNode p=root;
        double pre_value=-Double.MAX_VALUE;

        while (!stack.isEmpty()||p!=null){
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            if(p.val<=pre_value){
                return false;
            }
            pre_value=p.val;
            p=p.right;
        }
        return true;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
