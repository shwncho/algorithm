import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        final int MOD = 1_000_000_000;
        long[][] dp = new long[k+1][n+1];

        for(int i=0; i<=n; i++){
            dp[1][i]=1;
        }

        for(int i=1; i<=k; i++){
            for(int j=0; j<=n; j++){
                for(int m=0; m<=j; m++){
                    dp[i][j]+=dp[i-1][j-m];
                    dp[i][j]%=MOD;
                }
            }
        }

        System.out.println(dp[k][n]);

    }
}
