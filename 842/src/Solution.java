import java.util.ArrayList;
import java.util.List;

/**
 * @author:yixiaolan
 * @date:Created in 2020/12/9
 * @description:
 * @version:1.0
 */
public class Solution {
    //答案
    List<Integer> res;
    public List<Integer> splitIntoFibonacci(String S) {
        res = new ArrayList<>();
        backTrack(S.toCharArray(),0);
        return res;
    }
    private boolean backTrack(char[] digit,int index) {

        if(index == digit.length && res.size() >= 3){
            return true;
        }

        for (int i = index ; i < digit.length ; i++){
            if(digit[index] == '0' && i>index){
                break;
            }
            long num = subDigit(digit,index,i+1);
            if(num>Integer.MAX_VALUE){
                break;
            }
            int size = res.size();
            if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
                //把数字num添加到集合res中
                res.add((int) num);
                //如果找到了就直接返回
                if (backTrack(digit,i + 1))
                    return true;
                //如果没找到，就会走回溯这一步，然后把上一步添加到集合res中的数字给移除掉
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    private long subDigit(char[] digit, int start,int end){
        long res = 0;
        for (int i = start ; i<end ; i++){
            res = res * 10 + (digit[i] - '0');
        }
        return res;
    }
}
