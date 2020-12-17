import java.util.*;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/14
 * @description:
 * @version:1.0
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode node=root;
        Deque<TreeNode> treeNodeDeque = new LinkedList<TreeNode>();
        List<Integer> path=new ArrayList<>();
        while (node!=null||!treeNodeDeque.isEmpty()){
            while (node!=null){
                treeNodeDeque.push(node);
                node=node.left;
            }
            node=treeNodeDeque.pop();
            path.add(node.val);
            node=node.right;
        }
        return path;
    }
}
