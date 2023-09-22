import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[31][31];
        //0.5개만 있다면 경우의 수 1가지
        for(int i=1; i<31; i++){
            dp[0][i]=1;
        }

        //반 개를 먹은 상황에서 시작, 그렇기 때문에 반 알 짜리는 30개가 될 수 없음
        for(int i=1; i<31; i++){
            for(int j=0; j<30; j++){
                // 반 개 알약이 없는경우
                if(j==0)    dp[i][j] = dp[i-1][j+1];
                //한 개 알약 먹는 경우 + 반 개 알약 먹는경우
                else dp[i][j] = dp[i-1][j+1] + dp[i][j-1];
            }
        }


        StringBuilder sb = new StringBuilder();
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0)    break;

            sb.append(dp[n][0]).append("\n");

        }
        System.out.println(sb);
    }

}
