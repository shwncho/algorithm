class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];

        for(int[] e : edges) {
            indegree[e[1]]++;
        }

        int cnt = 0;
        int idx = 0;

        for(int i=0; i<n; i++) {
            if(indegree[i] == 0) {
                cnt++;
                idx = i;
            }
        }

        if(cnt==1)  return idx;
        return -1;

    }
}