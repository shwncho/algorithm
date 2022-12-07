import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");

        //(0,0)은 참조할 곳이 없으므로
        //(1,1)부터 Top-Down 방식으로 시작해야 범위를 안벗어남 -> 행,열 1줄씩 추가
        int[][] dp = new int[str1.length+1][str2.length+1];

        for(int i=1; i<=str1.length; i++){
            for(int j=1; j<=str2.length; j++){
                if(str1[i-1].equals(str2[j-1])){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

        System.out.println(dp[str1.length][str2.length]);
    }
}