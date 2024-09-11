import java.util.*;
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        final int MAX_VALUE = 100_000_000;
        Arrays.fill(dp, MAX_VALUE);
        dp[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=coins[i]; j<=amount; j++){
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
        System.out.println(dp[amount]);
        return dp[amount]== MAX_VALUE ? -1 : dp[amount];
    }
}