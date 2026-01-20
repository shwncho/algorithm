class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++)  graph.add(new ArrayList<>());

        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }


        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(visited[i])  continue;

            visited[i] = true;

            int nodes = 1;
            int lines = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            while(!q.isEmpty()) {
                Integer now = q.poll();

                lines += graph.get(now).size();
                for(Integer next : graph.get(now)) {
                    if(!visited[next]) {
                        visited[next] = true;
                        nodes++;
                        q.offer(next);
                    }
                }
            }

            if(lines/2 == nodes*(nodes-1)/2)  answer++;
        }

        return answer;

    }
}