class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int left = 0;
        int answer = 0;

        for(int right=0; right<nums.length; right++){
            if(nums[right]==0) left = right + 1;
            else {
                answer = Math.max(answer, right - left + 1);
            }
        }

        return answer;
    }
}