import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/19
 * @description:
 * @version:1.0
 */
public class Solution2 {
//    public int sumOfLeftLeaves(TreeNode root){
//        if(root==null){
//            return 0;
//        }
//        TreeNode node=root;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(node);
//        int ans = 0;
//        while (!queue.isEmpty()){
//            node=queue.poll();
//            if(node.left!=null){
//                if(node.left.left==null&&node.left.right==null){
//                    ans+=node.left.val;
//                }
//                else {
//                    queue.offer(node.left);
//            }
//                if(node.right!=null){
//                    if(!(node.right.left==null&&node.right.right==null){
//                        queue.offer(node.right);
//                    }
//                }
//           }
//
//        }
//        return ans;
//
//    }

    public boolean change(int[] pay){
        int five = 0;
        int ten = 0;
        for (int value : pay) {
            if (value == 5) {
                five++;
            } else if (value == 10) {
                if (five < 1) {
                    return false;
                } else {
                    ten++;
                    five--;
                }
            } else {
                if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    String game(int[] nums){
        char[] res = new char[9];
        int idx = 0;
        int div = 100;
        for(int i = 0; i<3; ++i){
            for(int j = 0; j<nums.length; ++j){
                res[idx++] = (char) (nums[j]/div + '0');
                nums[j] = nums[j]%div;
            }
            div /= 10;
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.change(new int[]{5,10,5,20,5,5,5,20}));
        System.out.println(sol.game(new int[]{259,746,138}));
    }
}
