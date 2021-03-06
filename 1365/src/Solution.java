import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/26
 * @description:
 * @version:1.0
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[][] data=new int[2][2];
        for(int i=0;i<n;i++){
            data[i][0]=nums[i];
            data[i][1]=i;
        }
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] ret = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            ret[data[i][1]] = prev;
        }
        return ret;

    }
}
