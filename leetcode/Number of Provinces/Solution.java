class Solution {
    private void DFS(int[][] isConnected, boolean[] visited, int node) {
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                DFS(isConnected, visited, i);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }
}