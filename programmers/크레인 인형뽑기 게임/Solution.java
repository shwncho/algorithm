import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();

        int N = board.length;

        for(int m : moves){
            for(int i=0; i<N; i++){
                if(board[i][m-1]!=0){
                    if(!stk.isEmpty() && stk.peek() == board[i][m-1]){
                        stk.pop();
                        answer+=2;
                    }
                    else    stk.push(board[i][m-1]);

                    board[i][m-1]=0;
                    break;
                }
            }
        }

        return answer;
    }
}