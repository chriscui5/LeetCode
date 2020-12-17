import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/8
 * @description:
 * @version:1.0
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);  // 便于后面的 “去重” 和 “剪枝”
        int length = nums.length;
        for (int index1 = 0; index1 < length - 3; index1++) {  // index1 为结果中 第一个值
            if (index1 > 0 && nums[index1] == nums[index1 - 1]) {
                continue;
            }

            /*
                剪枝：
                    1、当前最小和 > target，结束“当前层循环”
                    2、当前最大和 < target，跳过“当前循环”
             */
            int curMin = nums[index1] + nums[index1 + 1] + nums[index1 + 2] + nums[index1 + 3];
            if (curMin > target) {
                break;
            }
            int curMax = nums[index1] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (curMax < target) {
                continue;
            }
            for (int index2 = index1 + 1; index2 < length - 2; index2++) {  // index2 为结果中 第2个值
                if (index2 > index1 + 1 && nums[index2] == nums[index2 - 1]) {
                    continue;
                }
                int index3 = index2 + 1;
                int maxIndex = length - 1;

                /*
                    剪枝：
                        1、当前最小和 > target，结束“当前层循环”
                        2、当前最大和 < target，跳过“当前循环”
                 */
                curMin = nums[index1] + nums[index2] + nums[index3] + nums[index3 + 1];
                if (curMin > target) {
                    break;
                }
                curMax = nums[index1] + nums[index2] + nums[maxIndex] + nums[maxIndex - 1];
                if (curMax < target) {
                    continue;
                }
                //
                while (index3 < maxIndex) {  // index3 为结果中 第3个值
                    int curValue = nums[index1] + nums[index2] + nums[index3] + nums[maxIndex];
                    if (curValue == target) {
                        result.add(Arrays.asList(nums[index1], nums[index2], nums[index3], nums[maxIndex]));

                        /*
                            index3、maxIndex去重
                         */
                        index3++;
                        while (index3 < maxIndex && nums[index3] == nums[index3 - 1]) {
                            index3++;
                        }
                        maxIndex--;
                        while (index3 < maxIndex && nums[maxIndex] == nums[maxIndex + 1]) {
                            maxIndex--;
                        }
                    } else if (curValue > target) {
                        maxIndex--;
                    } else {
                        index3++;
                    }
                }
            }
        }
        return result;
    }
}
