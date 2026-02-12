import java.util.*;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        for(int n : nums1) {
            set.add(n);
        }

        for(int n : nums2) {
            if(set.contains(n)) result.add(n);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}