/**
 * @author:yixiaolan
 * @date:Created in 2020/10/29
 * @description:
 * @version:1.0
 */
public class Solution {
    public int longestMountain(int[] A) {
        int start=-1;
        int ans=0;
        int length=A.length;

        for (int i=1;i<length;i++){
            if(A[i-1]<A[i]){
                if(i==1||A[i-2]>=A[i-1]){
                    start=i-1;
                }
            }
            else if(A[i-1]>A[i]){
                if(start!=-1){
                    ans=Math.max(ans,i-start+1);
                }
            }
            else {
                start=-1;
            }
        }
        return ans;
    }
}
