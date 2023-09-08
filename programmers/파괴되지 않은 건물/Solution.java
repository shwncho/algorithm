import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int[][] tmp = new int[board.length+1][board[0].length+1];

        for(int[] arr : skill){
            int type = arr[0];
            int r1 = arr[1];
            int c1 = arr[2];
            int r2 = arr[3];
            int c2 = arr[4];
            int degree = arr[5];

            tmp[r1][c1] += type == 1 ? -degree : degree;
            tmp[r1][c2+1] += type == 1 ? degree : -degree;
            tmp[r2+1][c1] += type == 1 ? degree : -degree;
            tmp[r2+1][c2+1] += type == 1 ? -degree : degree;
        }

        for(int i=0; i<tmp.length-1; i++){
            for(int j=0; j<tmp[0].length-1; j++){
                tmp[i][j+1] += tmp[i][j];
            }
        }

        for(int i=0; i<tmp[0].length-1; i++){
            for(int j=0; j<tmp.length-1; j++){
                tmp[j+1][i] += tmp[j][i];
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] += tmp[i][j];
                if(board[i][j]>0)   answer++;
            }
        }

        return answer;
    }
}