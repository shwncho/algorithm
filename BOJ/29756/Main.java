import java.util.*;
import java.io.*;
public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][101];
        for(int i=0; i<=N; i++) Arrays.fill(dp[i],-1);

        int[] s = new int[N+1];
        int[] h = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            s[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            h[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(N,K,100,s,h));


    }

    private static int knapsack(int N, int K, int health, int[] s, int[] h) {
        if (N == 0) return 0;
        if (dp[N][health] != -1) return dp[N][health];

        int newHealth = Math.min(100, health + K);

        // 통과
        dp[N][health] = knapsack(N - 1, K, newHealth,s,h);

        if (newHealth >= h[N]) {
            dp[N][health] = Math.max(dp[N][health], knapsack(N - 1,K, newHealth - h[N],s,h) + s[N]);
        }

        return dp[N][health];
    }
}
