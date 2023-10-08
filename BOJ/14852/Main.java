import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int MOD = 1_000_000_007;
        long[][]dp = new long[1000001][2];

        dp[1][0]=2;
        dp[2][0]=7;
        dp[2][1]=1;
        for(int i=3; i<=1000000; i++){
            dp[i][1]=(dp[i-1][1]+dp[i-3][0])+MOD;
            dp[i][0]=(dp[i-1][0]*2 + dp[i-2][0]*3 + 2*dp[i][1]) % MOD;
        }

        System.out.println(dp[N][0]);
    }
}
