class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int answer = 1;
        int[] dp = new int[n];

        Arrays.sort(pairs, (a,b) -> a[0] - b[0]);
        Arrays.fill(dp,1);

        for(int i=1; i<n; i++) {
            int c = pairs[i][0];
            for(int j=0; j<i; j++) {
                int b = pairs[j][1];
                if(b < c) {
                    dp[i] = dp[j] + 1;
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}