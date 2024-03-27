import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        for(int i=0; i<n+1; i++){
            dp[i] = -1;
        }

        dp[2]=1;
        dp[3]=-1;
        dp[4]=2;
        dp[5]=1;
        for(int i=6; i<=n; i++){
            if(dp[i-2]!=-1) dp[i]=dp[i-2]+1;
            if(dp[i-5]!=-1) dp[i]=Math.min(dp[i-2]+1,dp[i-5]+1);
        }

        if(dp[n]==-1) System.out.println(-1);
        else System.out.println(dp[n]);

    }
}
