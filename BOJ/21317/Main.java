import java.util.*;
import java.io.*;
class Jump{
    public int small,big;
    Jump(int small, int big){
        this.small = small;
        this.big = big;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int MAX = 10_000_000;
        int N = Integer.parseInt(br.readLine());
        Jump[] arr = new Jump[21];
        int[][] dp = new int[2][21];

        Arrays.fill(dp[0],MAX);
        Arrays.fill(dp[1],MAX);

        Arrays.fill(arr,new Jump(0,0));
        for(int i=1; i<=N-1; i++){
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());
            arr[i]=new Jump(small, big);
        }
        int K = Integer.parseInt(br.readLine());

        dp[0][1]=0;
        dp[0][2]=arr[1].small;
        dp[0][3]=Math.min(dp[0][2]+arr[2].small, arr[1].big);

        for(int i=4; i<=N; i++){
            dp[0][i]=Math.min(dp[0][i-1]+arr[i-1].small, dp[0][i-2]+arr[i-2].big);
            dp[1][i]=Math.min(Math.min(dp[1][i-1]+arr[i-1].small, dp[1][i-2]+arr[i-2].big),K+dp[0][i-3]);
        }

        System.out.println(Math.min(dp[0][N],dp[1][N]));

    }
}
