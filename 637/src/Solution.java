import java.util.*;

/**
 * @author:yixiaolan
 * @date:Created in 2020/9/12
 * @description:
 * @version:1.0
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<>();
        TreeNode node=root;
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        int size_pre;
        int size_now=1;
        Double value_level;
        Double average_value_level;
        while (!queue.isEmpty()){
           size_pre=size_now;
           size_now=0;
           value_level=0.0;
            for(int i=0;i<size_pre;i++){
                node=queue.pop();
                value_level+=node.val*1.0;
                if(node.left!=null){
                    queue.add(node.left);
                    size_now++;
                }
                if(node.right!=null){
                    queue.add(node.right);
                    size_now++;
                }
            }
            average_value_level=value_level/size_pre;
            res.add(average_value_level);
        }
        return res;
    }
}
