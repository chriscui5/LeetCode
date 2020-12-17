/**
 * @author:yixiaolan
 * @date:Created in 2020/8/2
 * @description:
 * @version:1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
