/**
 * @author:yixiaolan
 * @date:Created in 2020/10/16
 * @description:
 * @version:1.0
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        int left=0;
        int length=A.length;
        int right=length-1;
        int index=length-1;
        int[] res=new int[length];
        while (index>=0){
            if(A[left]+A[right]<0){
                res[index--]=A[left]*A[left];
                left++;
            }
            else {
                res[index--]=A[right]*A[right];
                right--;
            }
        }
        return res;
    }
}
