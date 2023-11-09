import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)  arr[i] = Integer.parseInt(st.nextToken());

        int answer = 1;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if (arr[j]>arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(n-answer);
    }
}