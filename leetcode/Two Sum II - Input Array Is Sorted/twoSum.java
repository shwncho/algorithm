import java.io.*;
import java.util.*;
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0, right=numbers.length-1;
        int[] answer = new int[2];
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum==target){
                answer[0]=left+1;
                answer[1]=right+1;
                break;
            }
            else if(sum<target) left++;
            else    right--;
        }

        return answer;
    }
}