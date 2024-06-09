import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[201][201];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            visited[b+d][a+c] = true;
        }

        long[][] dp = new long[M+1][N+1];
        dp[0][0]=1;

        for(int i=1; i<=M; i++){
            if(visited[2*i-1][0])   break;
            dp[i][0]=1;
        }

        for(int i=1; i<=N; i++){
            if(visited[0][2*i-1])   break;
            dp[0][i]=1;
        }


        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
                if(!visited[2*i-1][2*j])   dp[i][j] += dp[i-1][j];
                if(!visited[2*i][2*j-1])     dp[i][j] +=dp[i][j-1];
            }
        }

        System.out.println(dp[M][N]);


    }
}
