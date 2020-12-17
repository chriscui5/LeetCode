import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/24
 * @description:
 * @version:1.0
 */
public class Solution {
    public int[] findMode(TreeNode root) {
        TreeNode tree=root;
        TreeNode pre=null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> answer = new ArrayList<Integer>();
        int maxCount=1;
        int count=1;

        while (tree != null || !stack.isEmpty()) {

            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }

            if (!stack.isEmpty()) {
                tree = stack.pop();

                if(pre!=null){
                    if(pre.val==tree.val){
                        count++;
                    }
                    else {
                        if(count==maxCount){
                            answer.add(pre.val);
                        }
                        else if(count>maxCount){
                            if(answer.size()==0){
                                answer.add(pre.val);
                            }
                            else {
                                answer.clear();
                                answer.add(pre.val);
                            }
                            maxCount=count;
                        }
                        count=1;
                    }
                }

                pre=tree;
                // System.out.println(tree.val);
                tree = tree.right;
            }
        }
        if(pre == null) return new int[0];
        if(count > maxCount){
            answer.clear();
            answer.add(pre.val);
        }else if(count == maxCount){
            answer.add(pre.val);
        }
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }

        return mode;

    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

