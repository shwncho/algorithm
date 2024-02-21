import java.util.*;
class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int MOD = 10007;

        int[][] dp = new int[n+1][2];

        dp[1][0]=1;
        dp[1][1]=tops[0]==0 ? 2 : 3;

        for(int i=2; i<=n; i++){

            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % MOD;

            if(tops[i-1]==0){
                dp[i][1] = (dp[i-1][0] + 2 * dp[i-1][1]) % MOD;
            }
            else    dp[i][1] = (2 * dp[i-1][0] + 3 * dp[i-1][1]) % MOD;
        }
        answer = (dp[n][0] + dp[n][1]) % MOD;
        return answer;
    }
}