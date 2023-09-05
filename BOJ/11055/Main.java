import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)  arr[i]=Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            dp[i]=arr[i];
            for(int j=0; j<n; j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],arr[i]+dp[j]);
                }
            }
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);

    }
}
