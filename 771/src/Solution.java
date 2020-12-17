import java.util.HashSet;
import java.util.Set;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/7
 * @description:
 * @version:1.0
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        int res=0;
        Set<Character> set=new HashSet<>();
        char[] jChar=J.toCharArray();
        char[] sChar=S.toCharArray();
        for (char j:jChar)
            set.add(j);
        for (char s:sChar){
            if(set.contains(s)){
                res++;
            }
        }
        return res;
    }
}
