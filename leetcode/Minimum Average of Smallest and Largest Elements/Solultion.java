import java.util.*;
class Solution {
    public double minimumAverage(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int right = n-1;
        double answer = 50;
        for(int i=0; i<n/2; i++) {
            double avg = (nums[i] + nums[right--])/(double)2;
            answer = Math.min(answer,avg);
        }

        return answer;
    }
}