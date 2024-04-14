import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] L = new int[N];
        int[] J = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[100];
        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=99; j>=L[i]; j--){
                dp[j] = Math.max(dp[j-L[i]]+J[i], dp[j]);
                max = Math.max(max,dp[j]);
            }
        }

        System.out.println(max);
    }
}
