import java.util.HashMap;
import java.util.Map;

/**
 * @author:yixiaolan
 * @date:Created in 2020/3/27
 * @description:
 * @version:1.0
 */
public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        if (len < 2) {
            return false;
        }

        // 计数数组，10000 是根据题目给出的数值范围定的
        int[] cnt = new int[10000];
        for (int num : deck) {
            cnt[num]++;
        }

        int x=cnt[deck[0]];
        for(int i=0;i<10000;i++){
            if(cnt[i]==1){
                return false;
            }
            if(cnt[i]>1){
                x=gongyue(x,cnt[i]);
                if(x==1){
                    return false;
                }
            }
        }
        return true;
    }
    //求最大公约数函数
    public int gongyue(int a,int b)
    {
        int gongyue=0;
        if(a<b)
        {   //交换a、b的值
            a=a+b;
            b=a-b;
            a=a-b;
        }
        if(a%b==0)
        {
            gongyue = b;
        }
        while(a % b>0)
        {
            a=a%b;
            if(a<b)
            {
                a=a+b;
                b=a-b;
                a=a-b;
            }
            if(a%b==0)
            {
                gongyue = b;
            }
        }
        return gongyue;
    }



}
