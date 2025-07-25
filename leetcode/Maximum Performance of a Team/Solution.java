class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int MOD = 1_000_000_007;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i] = new int[] {efficiency[i], speed[i]};
        }

        Arrays.sort(arr, (a,b) -> b[0] - a[0]);

        long answer = 0, sum = 0;
        Queue<Integer> minHeap = new PriorityQueue<>(k);

        for(int[] tmp : arr) {
            minHeap.offer(tmp[1]);
            sum += tmp[1];
            if(minHeap.size() > k) sum -= minHeap.poll();
            answer = Math.max(answer, sum * tmp[0]);
        }

        return (int)(answer % MOD);
    }
}