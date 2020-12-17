import java.util.*;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/27
 * @description:
 * @version:1.0
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;

        while (!stack.isEmpty() || node!=null){
            while (node!=null){
                res.add(node.val);
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            node=node.right;
        }
        return res;
    }
}
