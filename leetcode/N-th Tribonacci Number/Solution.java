class Solution {
    static int[] dp = new int[38];
    public int tribonacci(int n) {
        if(dp[n]!=0)    return dp[n];
        if(n==0)    return 0;
        if(n==1 || n==2)    return 1;
        return dp[n] = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }
}