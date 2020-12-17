import java.util.ArrayList;

/**
 * @author:yixiaolan
 * @date:Created in 2020/7/8
 * @description:
 * @version:1.0
 */
public class Solution {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] lengths = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lengths[i] = shorter * (k - i) + longer * i;
        }
        return lengths;
    }
    
}
