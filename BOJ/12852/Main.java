import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] parent = new int[n+1];

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i - 1] + 1;
            parent[i]=i-1;
            if (i % 3 == 0 && dp[i] > dp[i/3]+1){
                dp[i]= dp[i / 3] + 1;
                parent[i]=i/3;
            }
            if (i % 2 == 0 && dp[i] > dp[i/2]+1){
                dp[i] =dp[i / 2] + 1;
                parent[i]=i/2;
            }

        }

        StringBuilder sb = new StringBuilder();
        int num = n;

        sb.append(dp[n]).append("\n");
        while(num>0){
            sb.append(num).append(" ");
            num=parent[num];
        }

        System.out.println(sb);


    }
}
