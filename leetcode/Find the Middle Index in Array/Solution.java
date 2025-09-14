class Solution {
    public int findMiddleIndex(int[] nums) {
        int[] sum = new int[nums.length+1];
        for(int i=1; i<=nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        for(int i=0; i<nums.length; i++){
            if(sum[i] == (sum[nums.length]-sum[i+1])) return i;
        }

        return -1;
    }
}