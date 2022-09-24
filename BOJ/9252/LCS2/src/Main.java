import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int[][] dp = new int[str1.length+1][str2.length+1];

        for(int i=1; i<=str1.length; i++){
            for(int j=1; j<=str2.length; j++){
                if(str1[i-1]==str2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }

        }

        String answer = "";
        int i = dp.length - 1, j = dp[0].length - 1;
        while(i != 0 && j != 0) {
            if(dp[i][j] == dp[i - 1][j]) {
                i--;
            }
            else if(dp[i][j] == dp[i][j - 1]) {
                j--;
            }
            else {
                answer += str1[i - 1];
                i--;
                j--;
            }
        }

        System.out.println(dp[str1.length][str2.length]);
        System.out.println(new StringBuffer(answer).reverse());


    }
}
