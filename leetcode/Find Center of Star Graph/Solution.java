class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] num = new int[n+1];

        for(int[] arr : edges) {
            num[arr[0]]++;
            num[arr[1]]++;
        }

        for(int i=1; i<=n; i++) {
            if(num[i]==n-1) return i;
        }

        return -1;
    }
}