import java.util.*;
class Solution {
    public int minPairSum(int[] nums) {
        int answer = 0;
        int n = nums.length;
        Arrays.sort(nums);

        int right = n-1;
        for(int i=0; i<n/2; i++) {
            answer = Math.max(answer, nums[i] + nums[right--]);
        }

        return answer;
    }
}