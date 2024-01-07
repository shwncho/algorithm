import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N+1][N+1][11];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                for(int k=1; k<=10; k++){
                    if(k==map[i-1][j-1]){
                        dp[i][j][k]+=1;
                    }
                    dp[i][j][k] += dp[i-1][j][k] + dp[i][j-1][k] - dp[i-1][j-1][k];
                }
            }
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int k=1; k<=10; k++){
                if(dp[x2][y2][k]-dp[x2][y1-1][k]-dp[x1-1][y2][k]+dp[x1-1][y1-1][k]>=1)  sum++;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
