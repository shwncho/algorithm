class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            arr[i] = new int[] {nums2[i], nums1[i]};
        }

        Arrays.sort(arr, (a,b) -> b[0] - a[0]);
        Queue<Integer> minHeap = new PriorityQueue<>();

        long answer = 0, sum = 0;
        for(int[] tmp : arr) {

            minHeap.offer(tmp[1]);
            sum += tmp[1];

            if(minHeap.size() > k)   sum -= minHeap.poll();
            if(minHeap.size() == k)  answer = Math.max(answer, sum * tmp[0]);
        }

        return answer;
    }
}