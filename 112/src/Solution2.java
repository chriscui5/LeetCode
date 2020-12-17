/**
 * @author:yixiaolan
 * @date:Created in 2020/7/8
 * @description:
 * @version:1.0
 */
public class Solution2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
