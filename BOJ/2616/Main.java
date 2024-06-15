import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int val = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + val;
        }

        int M = Integer.parseInt(br.readLine());

        int[][] dp = new int[4][N+1];
        for(int i=1; i<=3; i++){
            for(int j=i*M; j<=N; j++){
                //j번째를 제외한 값과, j번째를 포함한 값을 비교
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j-M]+(arr[j]-arr[j-M]));
            }
        }

        System.out.println(dp[3][N]);
    }
}
