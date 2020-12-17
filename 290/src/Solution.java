import java.util.HashMap;
import java.util.Map;

/**
 * @author:yixiaolan
 * @date:Created in 2020/12/16
 * @description:
 * @version:1.0
 */
public class Solution {
    public boolean wordPattern(String pattern,String str){
        Map<Character,String> ch2str = new HashMap<Character, String>();

        String[] sArray = str.split(" ");
        int sArrayLength = sArray.length;
        int patternLength = pattern.length();

        if(sArrayLength != patternLength){
            return false;
        }

        for (int i = 0 ; i<sArrayLength ; i++){
            char p = pattern.charAt(i);
            if(!ch2str.containsKey(p)){
                if(ch2str.containsValue(sArray[i])){
                    ch2str.put(p,sArray[i]);
                }
                else {
                    return false;
                }
            }
            else {
                if(!ch2str.get(p).equals(sArray[i])){
                    return false;
                }
            }
        }
        return true;
    }
}
