import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long[] dp=new long[101];
        dp[1]=dp[2]=dp[3]=1;

        while(t-->0){
            int N = Integer.parseInt(br.readLine());
            for(int i=4; i<=N; i++){
                dp[i] = dp[i-2] + dp[i-3];
            }
            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }
}
