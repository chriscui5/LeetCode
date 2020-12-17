/**
 * @author:yixiaolan
 * @date:Created in 2020/9/19
 * @description:
 * @version:1.0
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root!=null){
            return dfs(root);
        }
        return 0;
    }

    private int dfs(TreeNode root) {
        int ans=0;
        if(root==null){
            return 0;
        }
        TreeNode node=root.left;
        if(node!=null){
            if(node.right==null&&node.left==null){
                 ans=node.val+dfs(node);
            }
            ans+=dfs(node);
        }
        node=root.right;
        if(node!=null){
            ans+=dfs(node);
        }
        return ans;

    }
}
