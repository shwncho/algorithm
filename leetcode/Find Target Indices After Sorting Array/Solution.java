import java.util.*;
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int cnt = 0;
        int lessThan = 0;

        for(int n : nums) {
            if(n==target) cnt++;
            else if(n<target) lessThan++;
        }

        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<cnt; i++) {
            answer.add(lessThan++);
        }

        return answer;
    }
}