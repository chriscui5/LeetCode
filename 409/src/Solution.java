public class Solution {
    public int longestPalindrome(String s) {
        int[] c = new int[58];
        for(char cc:s.toCharArray()) {
            c[(int)cc-'A']+=1;
        }
        int res = 0;
        boolean flg = false;
        for(int i = 0; i<58; i++) {
            if(c[i]%2==0&&c[i]!=0){
                res+=c[i];
                // flg = true;
            }
            if(c[i]%2==1){
                res+=c[i]-1;
                flg = true;
            }
        }
        if (flg) {
            return res+1;
        }else {
            return res;
        }
    }
}
