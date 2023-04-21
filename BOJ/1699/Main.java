import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            //1의 합으로만 이루어진 것이 최대 개수 이므로, 최댓값 초기화
            dp[i]=i;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j*j<=i; j++){
                dp[i]=Math.min(dp[i],dp[i-(j*j)]+1);
            }
        }

        System.out.println(dp[n]);

    }
}
