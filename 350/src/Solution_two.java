import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:yixiaolan
 * @date:Created in 2020/7/13
 * @description:
 * @version:1.0
 */
public class Solution_two {
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> temp = new ArrayList<>();

        Arrays.sort(nums1);

        Arrays.sort(nums2);

        for(int i = 0, j = 0; i < nums1.length && j < nums2.length; ){
            if(nums1[i] > nums2[j]) j++;
            else if(nums1[i] < nums2[j]) i++;
            else {
                temp.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[temp.size()];

        for(int i = 0; i < res.length; i++)
            res[i] = temp.get(i);

        return res;
    }
}
