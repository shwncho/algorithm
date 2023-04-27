import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        final int MOD = 10007;

        //dp[자릿수][자릿값]
        long[][] dp = new long[n+1][10];

        for(int i=0; i<=9; i++){
            dp[1][i]=1;
        }
        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                for(int k=0; k<=j; k++){
                    //연산과정에 MOD
                    dp[i][j]+=dp[i-1][k]%MOD;
                }
            }
        }

        long answer=0;
        for(int i=0; i<=9; i++){
            answer+=dp[n][i];
        }
        //결과에 MOD
        System.out.println(answer%MOD);
    }
}
