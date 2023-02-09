import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int k=0; k<t; k++){
            int n =Integer.parseInt(br.readLine());
            //n+2로 직전 대각선과 직전전 대각선을 확보해주는것이 중요
            int[][] dp = new int[2][n+2];

            for(int i=0; i<2; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=2; j<n+2; j++){
                    dp[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            for(int e=2; e<n+2; e++){
                for(int s=0; s<2; s++){

                    //윗 행
                    if(s==0){
                        dp[s][e]+=Math.max(dp[s+1][e-1],dp[s+1][e-2]);
                    }

                    //아래행
                    else{
                        dp[s][e]+=Math.max(dp[s-1][e-1],dp[s-1][e-2]);
                    }
                }
            }

            sb.append(Math.max(dp[0][n+1],dp[1][n+1])).append("\n");
        }

        System.out.println(sb);
    }
}
