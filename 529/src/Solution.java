/**
 * @author:yixiaolan
 * @date:Created in 2020/8/20
 * @description:
 * @version:1.0
 */
public class Solution {
    //定义8个方向
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];

        //(1)挖出***
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        //(2)判断当前点开得节点8个方向是否有雷，统计个数
        board[x][y] = 'B';
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 'M')
                cnt++;
        }
        if (cnt != 0) {
            board[x][y] = (char) (cnt + '0');
            return board;
        }
        //(3)递归搜索8个方向相邻的节点
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length
                    &&board[newX][newY]=='E')
                updateBoard(board, new int[]{newX, newY});
        }
        return board;
    }
}
