import java.io.*;
import java.util.*;
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int lMax = height[left], rMax = height[right];
        int answer = 0;
        while(left<right){
            if(lMax<=rMax){
                left++;
                lMax = Math.max(lMax, height[left]);
                answer += lMax - height[left];
            }
            else{
                right--;
                rMax = Math.max(rMax, height[right]);
                answer += rMax - height[right];
            }
        }

        return answer;
    }
}