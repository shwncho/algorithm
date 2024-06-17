import java.util.*;
import java.io.*;
public class Main {
    static int[][] map;
    static int N;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = 0;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                answer = Math.max(answer,DFS(i,j));
            }
        }

        System.out.println(answer);
    }

    private static int DFS(int x , int y){
        if(dp[x][y]!=0) return dp[x][y];

        dp[x][y]=1;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<N && 0<=ny && ny<N && map[x][y] < map[nx][ny]){
                dp[x][y] = Math.max(dp[x][y],DFS(nx,ny)+1);
            }
        }

        return dp[x][y];
    }
}
