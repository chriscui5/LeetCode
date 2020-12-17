/**
 * @author:yixiaolan
 * @date:Created in 2020/7/6
 * @description:
 * @version:1.0
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return (int) helper(obstacleGrid, 0, 0);
    }

    public static long helper(int[][] obstacleGrid, int down, int right) {
        if (obstacleGrid[down][right] == 1)
            return 0;
        if (right == obstacleGrid[0].length - 1 && down == obstacleGrid.length - 1) {
            if (obstacleGrid[down][right] == 1)
                return 0;
            else
                return 1;
        }
        if (right == obstacleGrid[0].length - 1 || down == obstacleGrid.length - 1) {
            if (right == obstacleGrid[0].length - 1)
                return helper(obstacleGrid, down + 1, right);
            return helper(obstacleGrid, down, right + 1);
        }
        return helper(obstacleGrid, down, right + 1) + helper(obstacleGrid, down + 1, right);
    }


}
