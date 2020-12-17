import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author:yixiaolan
 * @date:Created in 2020/8/8
 * @description:
 * @version:1.0
 */
public class Solution {

    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode firstErrorNode = null;
        TreeNode secondErrorNode= null;
        TreeNode pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pred!=null&&root.val < pred.val){
                secondErrorNode=root;
                if(firstErrorNode==null){
                    firstErrorNode=pred;
                }
                else {
                    break;
                }
            }

            pred = root;
            root = root.right;
        }
        swap(firstErrorNode, secondErrorNode);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }



}
