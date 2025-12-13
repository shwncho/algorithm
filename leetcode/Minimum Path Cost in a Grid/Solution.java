class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        // 경로 비용 + 셀의 합
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++)  Arrays.fill(dp[i], 1_000_000);
        Arrays.fill(dp[0],0);

        //현재 위치 i,j에서 k로 이동할 때의 최소 비용
        for(int i=0; i<m-1; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    dp[i+1][k] = Math.min(dp[i+1][k], dp[i][j] + moveCost[grid[i][j]][k] + grid[i][j]);
                }
            }
        }
        for(int i=0; i<n; i++)  dp[m-1][i] += grid[m-1][i];

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)  answer = Math.min(answer, dp[m-1][i]);
        return answer;
    }
}