class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;

        for(int n : nums)   result = Math.max(result, n);

        int curMin = 1, curMax = 1;

        for(int n : nums) {
            int tmp = curMax * n;
            curMax = Math.max(tmp, Math.max(curMin*n, n));
            curMin = Math.min(tmp, Math.min(curMin*n, n));

            result = Math.max(result, curMax);
        }


        return result;
    }
}