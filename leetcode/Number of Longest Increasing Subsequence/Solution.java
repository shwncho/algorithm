class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 1)    return 1;
        int max = 0;
        int answer = 0;
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];

        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                    else if(dp[j]+1 == dp[i]) cnt[i] += cnt[j];
                }
            }
            max = Math.max(max, dp[i]);
        }

        for(int i=0; i<n; i++)  if(dp[i] == max)    answer += cnt[i];

        return answer;
    }
}

// 1 2 3 3 4 4 5 1
// 1 1 1 1 2 1 3 1