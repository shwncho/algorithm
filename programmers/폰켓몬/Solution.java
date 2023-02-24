import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int x : nums){
            set.add(x);
        }

        int size = set.size();
        answer= size>(n/2) ? n/2 : size;


        return answer;
    }
}