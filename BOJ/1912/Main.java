import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            dp[i]=Integer.parseInt(st.nextToken());
        }

        int max = dp[1];

        for(int i=2; i<=n; i++){
            if(dp[i-1]>0 && dp[i]+dp[i-1]>0){
                dp[i]=dp[i]+dp[i-1];
            }

            if(max<dp[i]){
                max=dp[i];
            }
        }

        System.out.println(max);

    }
}
