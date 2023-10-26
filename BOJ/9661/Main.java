import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        int[] dp = new int[6];
        dp[1]=1;
        dp[2]=0;
        dp[3]=1;
        dp[4]=1;
        dp[5]=0;

        long idx = N%5;
        System.out.println(dp[(int)idx]==1 ? "SK" : "CY");

    }
}
