import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] coin;
        int[] dp;
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            coin=new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                coin[j]=Integer.parseInt(st.nextToken());
            }
            int change=Integer.parseInt(br.readLine());
            dp=new int[change+1];
            dp[0]=1;

            for(int k=0; k<n; k++){
                for(int s=coin[k]; s<=change; s++){
                    dp[s]=dp[s]+dp[s-coin[k]];
                }
            }
            sb.append(dp[change]).append("\n");
        }
        System.out.println(sb.toString());

    }
}
