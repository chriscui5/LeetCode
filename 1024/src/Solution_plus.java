/**
 * @author:yixiaolan
 * @date:Created in 2020/10/28
 * @description:
 * @version:1.0
 */
public class Solution_plus {
    public int videoStitching(int[][] clips, int T){
        if(clips==null){
            return 0;
        }
        int[] maxEnd=new int[T];
        for (int[] clip:clips){
            if(clip[0]<T){
                maxEnd[clip[0]]=Math.max(maxEnd[clip[0]],clip[1]);
            }
        }

        int pre=0;
        int last=0;
        int count=0;

        for (int i=0;i<T;i++){
            last=Math.max(maxEnd[i],last);
            if(i==last){
                return -1;
            }
            if(i==pre){
                count++;
                pre=last;
            }
        }
        return count;
    }
}
