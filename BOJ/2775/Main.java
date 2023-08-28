import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] dp;

        StringBuilder sb = new StringBuilder();
        while(t-->0){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            dp = new int[k+1][n+1];

            for(int i=1; i<=n; i++){
                dp[0][i]=i;
            }

            for(int i=1; i<=k; i++){
                dp[i][1]=dp[i-1][1];
                for(int j=2; j<=n; j++){
                    dp[i][j]+=dp[i][j-1]+dp[i-1][j];
                }
            }

            sb.append(dp[k][n]).append("\n");
        }

        System.out.println(sb);
    }
}
