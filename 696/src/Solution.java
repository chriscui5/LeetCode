/**
 * @author:yixiaolan
 * @date:Created in 2020/8/10
 * @description:
 * @version:1.0
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        int len=s.length();

        if(len<= 1)
            return 0;

        int[] count=new int[len];

        int sum=0;

        for(int i=0;i<len;i++){


            if(i==0){
                count[i]=1;
                continue;
            }
            else if(s.charAt(i-1)!=s.charAt(i)){
                count[i]=1;
            }
            else {
                count[i]=count[i-1]+1;
            }
            int m=i-count[i];
            if(m>=0&&s.charAt(i)!=s.charAt(m)&&count[m]>=count[i]){
                sum++;
            }
        }

        return sum;
    }
}
