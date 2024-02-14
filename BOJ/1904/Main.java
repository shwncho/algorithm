import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[1_000_001];
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<=1_000_000; i++){
            dp[i]=(dp[i-1]+dp[i-2]) % 15746;
        }

        System.out.println(dp[n]);
    }
}
