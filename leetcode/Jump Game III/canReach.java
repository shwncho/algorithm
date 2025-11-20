class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<int[]> q = new LinkedList<>();

        int n = arr.length;
        boolean[] visited = new boolean[n];

        q.offer(new int[]{start,arr[start]});
        visited[start]=true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int idx = now[0];
            int val = now[1];

            if(val==0)  return true;

            if(idx + arr[idx] < n && !visited[idx+arr[idx]]) {
                visited[idx+arr[idx]] = true;
                q.offer(new int[]{idx+arr[idx],arr[idx+arr[idx]]});
            }

            if(idx - arr[idx] >=0 && !visited[idx-arr[idx]]) {
                visited[idx-arr[idx]] = true;
                q.offer(new int[]{idx-arr[idx],arr[idx-arr[idx]]});
            }
        }


        return false;
    }
}