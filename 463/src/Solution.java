/**
 * @author:yixiaolan
 * @date:Created in 2020/10/30
 * @description:
 * @version:1.0
 */
public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int islandPerimeter(int[][] grid) {
        int hang=grid.length;
        int lie=grid[0].length;
        int ans=0;
        for(int i=0;i<hang;i++){
            for (int j = 0; j < lie; ++j){
                if(grid[i][j]==1){
                    ans+=4;
                    for(int k=0;k<4;k++){
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if( tx>=0 && tx<hang && ty>=0 && ty<lie && grid[tx][ty]==1){
                            ans-=1;
                        }
                    }
                }
            }
        }
        return ans;
    }

}
