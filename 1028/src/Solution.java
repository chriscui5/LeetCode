import java.util.Stack;

/**
 * @author:yixiaolan
 * @date:Created in 2020/6/18
 * @description:
 * @version:1.0
 */
public class Solution {
    public TreeNode recoverFromPreorder(String s) {
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
        while (i < s.length()){

            /**
             * 如果root==null，先设置根节点
             */
            if(root == null){
                //因为节点的值介于 1 和 10 ^ 9 之间，所以需要遍历计算val
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) -  '0');
                    i ++;
                }
                root = new TreeNode(val);

                //根节点入栈
                stack.push(root);
            }else if(s.charAt(i) == '-'){
                cutLevel ++;
                i++;
            }else {
                val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) -  '0');
                    i ++;
                }
                /**
                 * 左子树
                 * 如果当前cutLevel > prevLevel,说明是下一级，取栈顶节点
                 * */
                if(cutLevel > prevLevel){
                    TreeNode node = stack.pop();
                    node.left = new TreeNode(val);
                    //入栈的时候，需要将之前栈顶元素先入栈，然后node.left或者node.right再入栈
                    stack.push(node);
                    stack.push(node.left);
                    //然后cutLevel赋给prevLevel，cutLevel置0
                    prevLevel = cutLevel;
                    cutLevel = 0;
                } else {
                    /**
                     * 右子树
                     * 根据cutLevel的值，回溯到上一级
                     */
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
