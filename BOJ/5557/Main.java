import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        long[][] dp = new long[N][21];


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  num[i] = Integer.parseInt(st.nextToken());

        dp[0][num[0]]=1;

        for(int i=1; i<=N-1; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j]!=0){
                    if(j+num[i]<=20)    dp[i][j+num[i]]+=dp[i-1][j];
                    if(j-num[i]>=0) dp[i][j-num[i]]+=dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N-2][num[N-1]]);

    }

}
