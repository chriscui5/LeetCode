/**
 * @author:yixiaolan
 * @date:Created in 2020/8/2
 * @description:
 * @version:1.0
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


}
