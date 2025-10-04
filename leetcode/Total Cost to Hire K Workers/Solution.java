class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long answer = 0;

        Queue<Integer> lQ = new PriorityQueue<>();
        Queue<Integer> rQ = new PriorityQueue<>();

        int left = 0;
        int right = costs.length - 1;

        while(k-->0) {

            while(lQ.size() < candidates && left <= right)  lQ.offer(costs[left++]);
            while(rQ.size() < candidates && left <= right)  rQ.offer(costs[right--]);

            int ln = !lQ.isEmpty() ? lQ.peek() : Integer.MAX_VALUE;
            int rn = !rQ.isEmpty() ? rQ.peek() : Integer.MAX_VALUE;

            if(ln <= rn) answer += lQ.poll();
            else    answer += rQ.poll();
        }

        return answer;
    }
}