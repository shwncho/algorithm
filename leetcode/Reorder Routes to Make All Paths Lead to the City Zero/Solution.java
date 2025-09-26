class Solution {
    private int DFS(List<List<Integer>> graph, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for(int to : graph.get(from)){
            if(!visited[Math.abs(to)]){
                change += DFS(graph, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }
        return change;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){ graph.add(new ArrayList<>()); }

        for(int[] c : connections) {
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(-c[0]);
        }


        return DFS(graph, new boolean[n], 0);
    }
}