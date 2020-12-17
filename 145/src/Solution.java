import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/29
 * @description:
 * @version:1.0
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack=new LinkedList<TreeNode>();
        TreeNode prev=null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(root.right==null|root.right==prev){
                res.add(root.val);
                prev=root;
                root=null;
            }
            else {
                stack.push(root);
                root=root.right;
            }
        }
        return res;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
