import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/29
 * @description:
 * @version:1.0
 */
public class Solution_plus {
    public int sumNumbers(TreeNode root){
        if (root==null){
            return 0;
        }
        int sum=0;
        Queue<TreeNode> queue_treenode=new LinkedList<TreeNode>();
        Queue<Integer> queue_integer=new LinkedList<Integer>();
        queue_treenode.offer(root);
        queue_integer.offer(root.val);
        while (!queue_treenode.isEmpty()){
            TreeNode node=queue_treenode.poll();
            int num=queue_integer.poll();
            TreeNode node_left=node.left;
            TreeNode node_right=node.right;

            if (node_left==null && node_right==null){
                sum=sum+num;
            }
            else {
                if (node_left!=null){
                    queue_treenode.offer(node_left);
                    queue_integer.offer(num*10+node_left.val);
                }
                else {
                    queue_treenode.offer(node_right);
                    queue_integer.offer(num*10+node_right.val);
                }
            }
        }
        return sum;
    }
}
