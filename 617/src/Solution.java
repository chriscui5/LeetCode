import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/23
 * @description:
 * @version:1.0
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        TreeNode merged= new TreeNode(t1.val+t2.val);
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        Queue<TreeNode> queue1=new LinkedList<TreeNode>();
        Queue<TreeNode> queue2=new LinkedList<TreeNode>();
        queue.offer(merged);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty()&&!queue2.isEmpty()){
            TreeNode node=queue.poll();
            TreeNode node1=queue1.poll();
            TreeNode node2=queue2.poll();
            TreeNode left1=node1.left;
            TreeNode left2=node2.left;
            TreeNode right1=node1.right;
            TreeNode right2=node2.right;
            if( left1 != null || left2 != null){
                if(left1!=null&&left2!=null){
                    TreeNode left=new TreeNode(left1.val+left2.val);
                    node.left=left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                }
                else if(left1!=null){
                    node.left=left1;
                }
                else if(left2!=null){
                    node.left=left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;
    }
}
