/**
 * @author:yixiaolan
 * @date:Created in 2020/12/16
 * @description:
 * @version:1.0
 */
public class Solution {
    //找出小于等于这个数字的最大的数字
    //并且在个位数上 数字是保持单调递增的
    //
    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i=1;
        int len = strN.length;
        while (i<len && strN[i-1] < strN[i]){
            i += 1;
        }
        if(i<strN.length){
            while (i>0 && strN[i-1]>strN[i]){
                strN[i-1] -= 1;
                i -=1;
            }
            for ( i += 1;i<strN.length;i++){
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
