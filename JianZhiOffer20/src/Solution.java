/**
 * @author:yixiaolan
 * @date:Created in 2020/9/2
 * @description:
 * @version:1.0
 */
public class Solution {
    public boolean isNumber(String s) {
        if(s==null||s.length()==0) return false;
        boolean is_Num=false;
        boolean is_E=false;
        boolean is_Dot=false;
        char[] str = s.trim().toCharArray();
        int len=str.length;
        for(int i=0;i<len;i++){
            if(str[i]>='0'&&str[i]<='9') {
                is_Num=true;
            }
            else if(str[i]=='.'){
                if(is_Dot||is_E) return false;
                is_Dot=true;
            }
            else if(str[i]=='e'||str[i]=='E'){
                if(!is_Num||is_E) return false;
                is_Num=false;
                is_E=true;
            }
            else if(str[i]=='+'||str[i]=='-'){
                if(i!=0&&str[i-1]!='E'&&str[i-1]!='e') return false;
            }
            else {
                return false;
            }
        }
        return is_Num;
    }
}
