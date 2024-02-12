import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[501][501];
        int[][] dp = new int[501][501];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
            }
        }

        int max = 0;
        for(int i=1; i<=n; i++){
            max = Math.max(max, dp[n][i]);
        }

        System.out.println(max);

    }
}
