class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, answer = 0;
        int zeroCnt = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0)    zeroCnt++;

            while(zeroCnt > 1) {
                if(nums[left++]==0) zeroCnt--;
            }

            answer = Math.max(answer, right - left);
        }

        return answer;
    }
}