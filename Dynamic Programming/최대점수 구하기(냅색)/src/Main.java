import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] dp;
    static int[][] score;
    public static int solution(){
        for(int i=0; i<n; i++){
            /**
             * j++방식으로 증가해가면 이전에 풀었던 문제를 중복해서 풀기 때문에 j--방식으로 풀이
             * ex) j=5, dp[5]일 때, dp[10]=dp[5]+dp[10]
             */

            for(int j=m; j>=score[i][1]; j--){
                dp[j]=Math.max(dp[j],dp[j-score[i][1]]+score[i][0]);
            }
        }

        return dp[m];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        dp=new int [m+1];
        score=new int[n][2];

        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                score[i][j]=sc.nextInt();
            }
        }

        System.out.println(solution());


    }
}
