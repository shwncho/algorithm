import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234;

        answer = calculate(board.length,board[0].length, board);

        return answer;
    }
    private int calculate(int n, int m, int[][] board){

        int[][] copyBoard = new int[n+1][m+1];
        int result = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copyBoard[i+1][j+1]=board[i][j];
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(copyBoard[i][j]!=0){
                    copyBoard[i][j] = Math.min(Math.min(copyBoard[i-1][j],copyBoard[i][j-1]),copyBoard[i-1][j-1])+1;
                    result = Math.max(result, copyBoard[i][j]);
                }

            }
        }

        return result * result;
    }
}