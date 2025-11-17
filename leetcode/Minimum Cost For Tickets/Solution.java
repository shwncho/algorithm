class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[days[n-1]+1];
        dp[0] = 0;

        boolean[] visited = new boolean[days[n-1]+1];
        for(int idx : days) visited[idx] = true;

        for(int i=1; i<=days[n-1]; i++) {
            if(!visited[i]) {
                dp[i] = dp[i-1];
                continue;
            }

            dp[i] = dp[i-1] + costs[0];
            dp[i] = Math.min(dp[Math.max(0,i-7)]+costs[1], dp[i]);
            dp[i] = Math.min(dp[Math.max(0,i-30)]+costs[2], dp[i]);
        }


        return dp[days[n-1]];
    }
}