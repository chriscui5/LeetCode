import java.util.*;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/6
 * @description:
 * @version:1.0
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        TreeNode node;
        int size;

        if (root == null) {
            return levelOrder;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            size=queue.size();
            for(int i=0;i<size;i++){
                node=queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            levelOrder.add(0,level);

        }
        return levelOrder;
    }
}
