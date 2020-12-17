/**
 * @author:yixiaolan
 * @date:Created in 2020/9/21
 * @description:
 * @version:1.0
 */
public class Solution {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            sum+=root.val;
            root.val=sum;
            convertBST(root.left);

        }
        return root;
    }




}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
