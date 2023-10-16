import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1005];
        dp[1]=1;
        dp[2]=0;
        dp[3]=1;
        dp[4]=1;

        for(int i=5; i<=N; i++){
            //창영이가 i-1, i-3, i-4에서 딱 맞춰서 이길 수 있다는 뜻은 상근이가 거기서 1,3,4를 선택함으로써 N번째에 자기가 이길 수 있다는 뜻
            // 반대로 i-1, i-3, i-4에서 상근이가 이길 수 있다는 뜻은 N번째에 창영이가 이길 수 있다는 뜻
            if(dp[i-1]==0 || dp[i-3]==0 || dp[i-4]==0) dp[i]=1;
            else dp[i]=0;
        }

        System.out.println(dp[N]==1 ? "SK" : "CY");
    }
}
