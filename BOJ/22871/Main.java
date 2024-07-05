import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[N];
        dp[0] = 0;
        for(int i=1; i<N; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0; j<i; j++){
                dp[i] = Math.min(dp[i],Math.max(dp[j],(i-j) * (1+Math.abs(arr[i] - arr[j]))));
            }
        }
        System.out.println(dp[N-1]);
    }
}
