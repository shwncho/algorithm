import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        int[][] arr = new int[K][2];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<K; i++){
            for(int j=N; j>=arr[i][1]; j--){
                dp[j] = Math.max(dp[j], dp[j-arr[i][1]]+arr[i][0]);
            }
        }

        System.out.println(dp[N]);


    }
}
