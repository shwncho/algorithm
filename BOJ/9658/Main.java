import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1005];
        dp[1]=0;
        dp[2]=1;
        dp[3]=0;
        dp[4]=1;

        for(int i=5; i<=N; i++){
            if(dp[i-1]==0 || dp[i-3]==0 || dp[i-4]==0) dp[i]=1;
            else dp[i]=0;
        }

        System.out.println(dp[N]==1 ? "SK" : "CY");
    }
}
