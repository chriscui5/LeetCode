/**
 * @author:yixiaolan
 * @date:Created in 2020/10/21
 * @description:
 * @version:1.0
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        while (j<typed.length()){
            if(i<name.length()&&name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }
            else if(j>0&&typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }else {
                return false;
            }
        }
        return i==name.length();
    }
}
