import java.util.*;
import java.io.*;
public class Main{
    static int[] arr,l_dp,r_dp;
    public static void LIS(){
        for(int i=0; i<arr.length; i++){
            l_dp[i]=1;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    l_dp[i]=Math.max(l_dp[i],l_dp[j]+1);
                }
            }
        }
    }

    public static void LDS(){
        for(int i=arr.length-1; i>=0; i--){
            r_dp[i]=1;
            for(int j= arr.length-1; j>i; j--){
                if(arr[i]>arr[j]){
                    r_dp[i]=Math.max(r_dp[i],r_dp[j]+1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        l_dp=new int[n];
        r_dp=new int[n];

        st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            max = Math.max(max, l_dp[i]+r_dp[i]-1);
        }

        System.out.println(max);
    }
}