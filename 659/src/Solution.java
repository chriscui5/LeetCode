import java.util.HashMap;
import java.util.Map;

/**
 * @author:yixiaolan
 * @date:Created in 2020/12/4
 * @description:
 * @version:1.0
 */
public class Solution {
    public boolean isPossible(int[] nums) {
        //用一个哈希表统计每个元素出现的次数
        Map<Integer,Integer> countNum = new HashMap<Integer, Integer>();
        for (int num:nums){
            countNum.put(num,countNum.getOrDefault(num,0)+1);
        }

        //定义一个哈希表记录最长的子序列
        Map<Integer,Integer> tail = new HashMap<Integer, Integer>();

        for (int num:nums){
            int count = countNum.getOrDefault(num,0);
            if(count<=0){
                continue;
            }
            else if(tail.getOrDefault(num - 1, 0) > 0){
                countNum.put(num, count - 1);
                tail.put(num - 1, tail.get(num - 1) - 1);//覆盖当前最长的子序列
                tail.put(num, tail.getOrDefault(num, 0) + 1);//当前以num结尾的子序列+1
            }
            else if (countNum.getOrDefault(num + 1, 0) > 0 && countNum.getOrDefault(num + 2, 0) > 0) {//前面无数字构成子序列后，判断能不能跟后面的构成子序列
                countNum.put(num, count - 1);
                countNum.put(num + 1, countNum.get(num + 1) - 1);
                countNum.put(num + 2, countNum.get(num + 2) - 1);
                tail.put(num + 2, tail.getOrDefault(num + 2, 0) + 1);//当前以num+2结尾的子序列+1
            }
            else
                return false;
        }
        return true;
    }
}
