import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());


        int[][] dp = new int[31][31];

        dp[1][1]=1;
        for(int i=1; i<=30; i++){
            for(int j=1; j<=i; j++){
                if(i==j || j==1)    dp[i][j]=1;
                else dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        int answer = 0;
        for(int i=0; i<W; i++){
            for(int j=0; j<=i; j++){
                answer += dp[R+i][C+j];
            }
        }

        System.out.println(answer);
    }
}
