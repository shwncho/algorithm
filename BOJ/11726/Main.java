import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[1001];

        dp[1]=1;
        dp[2]=2;

        for(int i=3; i<=1000; i++){
            //long도 오버플로우 나므로 연산마다 나머지 적용
            dp[i]=(dp[i-1]+dp[i-2])%10007;
        }

        System.out.println(dp[n]);
    }
}