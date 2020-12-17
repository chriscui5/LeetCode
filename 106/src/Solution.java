
import java.util.HashMap;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/25
 * @description:
 * @version:1.0
 */
public class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder,int[] postorder){
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder,int instart,int inend,int[] postorder,int poststart,int postend){
        if(instart>inend||poststart>postend){
            return null;
        }
        int root=postorder[postend];
        int mid=map.get(root);
        TreeNode node=new TreeNode(root);
        node.left=buildTree(inorder,instart,mid-1,postorder,poststart,poststart+mid-instart-1);
        node.right=buildTree(inorder,mid+1,inend,postorder,poststart+mid-instart,poststart-1);
        return node;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}