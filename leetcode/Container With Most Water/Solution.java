import java.util.*;
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int answer = 0;
        while(left < right) {
            if(height[left] <= height[right]) {
                answer = Math.max(answer, (right - left) * height[left]);
                left++;
            }
            else{
                answer = Math.max(answer, (right - left) * height[right]);
                right--;
            }
        }
        return answer;
    }
}