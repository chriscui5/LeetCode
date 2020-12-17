/**
 * @author:yixiaolan
 * @date:Created in 2020/10/19
 * @description:
 * @version:1.0
 */
public class Solution {
    private int count;
    private int[] board;
    private int max;
    public int totalNQueens(int n) {
        count=0;
        max=n;
        board=new int[n];
        place(0);
        return count;
    }

    public void place(int position) {
        int i;
        for (i=0;i<max;i++){
            board[position] = i; /* 将皇后摆到当前循环到的位置 */
            if(check(position)==1)
            {
                if(position == max - 1)
                {
                    count=count+1;
                }
                else
                {
                    place(position + 1); /* 否则继续摆放下一个皇后 */
                }
            }
        }
    }

    public int check(int position){
        for(int i=0;i<position;i++){
            if(board[i]==board[position]||Math.abs(board[i]-board[position])==Math.abs(i-position)){
                return 0;
            }
        }
        return 1;
    }


}
