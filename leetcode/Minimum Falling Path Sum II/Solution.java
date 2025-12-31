class Solution {
    public int minFallingPathSum(int[][] grid) {
        int answer = 20000;

        int n = grid.length;

        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++)  dp[0][i] = grid[0][i];

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=0; k<n; k++) {
                    if(j==k)    continue;

                    dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i-1][k]);
                }
            }
        }

        for(int i=0; i<n; i++)  answer = Math.min(answer, dp[n-1][i]);
        return answer;
    }
}