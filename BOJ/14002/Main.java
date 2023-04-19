import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n= Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] answer = new int[n];

        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }

        int idx=0;
        while(n>0){
            if(dp[n-1]==max){
                answer[idx++]=arr[n-1];
                max--;

            }
            n--;
        }

        System.out.println(idx);
        for(int k=idx-1; k>=0; k--){
            System.out.print(answer[k]+" ");
        }


    }
}
