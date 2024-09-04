import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int nowMax = 0;

        for(int i=0; i<nums.length; i++){
            nowMax = Math.max(nowMax + nums[i], nums[i]);
            answer = Math.max(answer, nowMax);
        }

        return answer;
    }
}