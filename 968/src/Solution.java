import java.util.ArrayList;
import java.util.Stack;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/22
 * @description:
 * @version:1.0
 */
public class Solution {
    public int minCameraCover(TreeNode root) {
        if (lrd(root) == 0) {
            res++;
        }
        return res;
    }

    int res=0;
    int lrd(TreeNode node) {

        if (node == null) {
            return 1;
        }
        int left=lrd(node.left);
        int right=lrd(node.right);
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        if(left==1&&right==1){
            return 0;
        }
        if(left+right>=3){
            return 1;
        }

        return -1;
    }

    public void  postorder(TreeNode biTree) {
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。

        while(biTree != null || !stack.empty())
        {
            while(biTree != null)
            {//将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(biTree);
                stack2.push(left);
                biTree = biTree.left;
            }

            while(!stack.empty() && stack2.peek() == right)
            {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.println(stack.pop().val);
            }

            if(!stack.empty() && stack2.peek() == left)
            {//如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                biTree = stack.peek().right;
            }

        }

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}