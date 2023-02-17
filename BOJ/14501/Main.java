import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        int[] t = new int[n];
        int[] p = new int[n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        //dp[n] 에는 n번째 날까지의 최대값을 저
        for(int i=0; i<n; i++){
            if(i+t[i]-1<n){
                dp[i+t[i]]=Math.max(dp[i]+p[i],dp[i+t[i]]);
            }
            //이 식을 안해주면 dp[i+t[i]] 번째의 날들만 기록
            //ex)  1-> 4 -> 5 , dp[2] 기록안됨, 3 -> 4 -> 5
            //  4 -> 5, 5, 6,7 기록안됨
            // i+t[i]번째로만 이동하지 않고, 뒤에 더 큰 금액을 받을 수 있는 인덱스가 있을 수 있으므로 i+1에 i번째 날과 i+1번재 날 중 최대값 기록
            dp[i+1]=Math.max(dp[i+1],dp[i]);

        }

        System.out.println(dp[n]);

    }
}
