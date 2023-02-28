import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        int[] p = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            p[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){
                dp[j]=Math.min(dp[j],dp[j-i]+p[i]);
            }
        }
        System.out.println(dp[n]);
    }
}