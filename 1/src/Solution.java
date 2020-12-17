import java.util.HashMap;
import java.util.Map;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/7
 * @description:
 * @version:1.0
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashtable=new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++){
            if(hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get(target-nums[i]),i};
            }
            hashtable.put(nums[i],i);
        }
        return new int[0];
    }
}
