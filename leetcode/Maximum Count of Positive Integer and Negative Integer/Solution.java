class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;

        int left = 0;
        int right = nums.length - 1;

        if(nums[left]==0 && nums[right]==0) return 0;

        while(left < right) {
            int mid = (left + right) / 2;

            if(nums[mid] <= 0) {
                left = mid +1;
            }
            else right = mid;
        }
        pos = nums.length - 1 - right + 1 ;

        left = 0;
        right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] <0) {
                left = mid +1;
            }
            else right = mid;
        }
        neg = left;

        if(nums[nums.length-1] < 0) neg = nums.length;
        return Math.max(pos,neg);
    }
}