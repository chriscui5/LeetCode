import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:yixiaolan
 * @date:Created in 2020/8/7
 * @description:
 * @version:1.0
 */
public class Solution {
    private int[] location;
    private boolean[] used;
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if(n == 0){
            ans.add(new ArrayList<String>());
            return ans;
        }
        location = new int[n];
        used = new boolean[n];
        Arrays.fill(location, 0);
        Arrays.fill(used, false);
        solve(0,n);
        return ans;
    }

    private void solve(int k, int n){
        for(int i = 0; i<n;i++){
            if(!used[i]){
                location[k] = i;
                used[i] = true;
                if(check(k) && k != n-1){
                    solve(k+1, n);
                }else if(check(k) && k==n-1){
                    convertAns(n);
                    //solutions += 1;
                }
                used[i] = false; //还原现场
            }
        }
    }

    private boolean check(int k){
        for(int i = 0;i<k;i++){
            if(Math.abs(location[i] - location[k]) == Math.abs(i-k)){
                return false;
            }
        }
        return true;
    }

    private void convertAns(int n){
        List<String> output = new ArrayList<>();
        for(int i = 0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<n;j++){
                sb.append(j == location[i] ? "Q":".");
            }
            output.add(sb.toString());
        }
        ans.add(output);
    }

}
