import java.util.Stack;

/**
 * @author:yixiaolan
 * @date:Created in 2020/6/18
 * @description:
 * @version:1.0
 */
public class Solution2 {
    public TreeNode recoverFromPreorder(String s){
        //最终的返回的根节点
        TreeNode root = null;
        Stack<TreeNode> stack = new Stack<>();

        //记录上一次遍历到第几层
        int prevLevel = 0;

        //当前层
        int cutLevel = 0;

        //节点值
        int val = 0;
        int i = 0;

        while (i<s.length()){
            if (root==null){
                while (i<s.length()&&Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) -  '0');
                    i ++;
                }
                root = new TreeNode(val);
                stack.push(root);
            }
            else if (Character.isDigit(s.charAt(i))){
                cutLevel++;
                i++;
            }
            else {
                if (cutLevel>prevLevel){
                    TreeNode node = stack.pop();
                    node.left = new TreeNode(val);
                    stack.push(node);
                    stack.push(node.left);
                    prevLevel = cutLevel;
                    cutLevel = 0;
                }else {
                    while (stack.size() > cutLevel){
                        stack.pop();
                    }
                    TreeNode node = stack.pop();
                    node.right = new TreeNode(val);
                    stack.push(node);
                    stack.push(node.right);
                    prevLevel = cutLevel;
                    cutLevel = 0;

                }

            }
        }
        return root;

    }
}
