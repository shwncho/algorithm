import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m =Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        //왼쪽 구간과 vipSeats 사이 계산
        int answer = 1;
        int beforeVipSeat = 0;
        for(int i = 0; i<m; i++){
            int num = Integer.parseInt(br.readLine());
            answer *= dp[num - beforeVipSeat -1];
            beforeVipSeat = num;
        }
        //마지막 오른쪽 구간
        answer *= dp[n - beforeVipSeat];
        System.out.println(answer);

    }
}
