import java.util.*;
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for(int i=0; i<nums1.length; i++) {
            s1.add(nums1[i]);
        }

        for(int i=0; i<nums2.length; i++){
            s2.add(nums2[i]);
        }

        for(int tmp : s1){
            if(!s2.contains(tmp))   answer.get(0).add(tmp);
        }

        for(int tmp : s2) {
            if(!s1.contains(tmp))   answer.get(1).add(tmp);
        }

        return answer;
    }
}