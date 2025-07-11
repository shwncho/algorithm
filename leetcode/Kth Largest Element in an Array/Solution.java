import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++){
            q.offer(nums[i]);
        }

        for(int i=0; i<k-1; i++){
            q.poll();
        }

        return q.poll();
    }
}