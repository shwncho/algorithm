import java.util.*;
class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = Integer.MAX_VALUE;
    static int n;
    static boolean[][] visited;
    static int[][] dp;
    public int solution(int[][] board) {
        n = board.length;
        dp = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        //오른쪽을 먼저 가는 경우
        if(board[0][1]!=1){
            visited = new boolean[n][n];
            visited[0][0]=true;
            visited[0][1]=true;
            DFS(board,1,0,1,100);
        }

        //밑을 먼저 가는 경우
        if(board[1][0]!=1){
            visited = new boolean[n][n];
            visited[0][0]=true;
            visited[1][0]=true;
            DFS(board,2,1,0,100);
        }

        return answer;
    }
    private void DFS(int[][] board, int pos, int x, int y, int sum){
        //경로 최적화
        if(dp[x][y]<sum)    return;
        else    dp[x][y] = sum;

        if(x==n-1 && y==n-1){
            answer = Math.min(answer, sum);
            return;
        }


        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=n)  continue;
            if(board[nx][ny]==1)    continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny]=true;
            if(i==pos){
                DFS(board,pos,nx,ny,sum+100);
            }
            else{
                DFS(board,i,nx,ny,sum+600);
            }
            visited[nx][ny]=false;

        }
    }
}