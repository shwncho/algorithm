class Solution {
    static class Node implements Comparable<Node> {
        int to;
        int w;

        Node(int to, int w){
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Node>> graph = new ArrayList<>();

        for(int i=0; i<n; i++)  graph.add(new ArrayList<>());

        for(int[] e : edges) {
            graph.get(e[0]).add(new Node(e[1],e[2]));
            graph.get(e[1]).add(new Node(e[0],e[2]));
        }

        int answer = 101;
        int minReachable = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            int reachable = dijkstra(i,n,graph,distanceThreshold);

            if(reachable <= minReachable) {
                minReachable = reachable;
                answer = i;
            }
        }

        return answer;
    }

    private static int dijkstra(int start, int n, List<List<Node>> graph, int threshold) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]=0;

        Queue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(start,0));

        while(!pQ.isEmpty()) {
            Node now = pQ.poll();

            if(dist[now.to] < now.w)    continue;
            for(Node next : graph.get(now.to)) {
                if(dist[next.to] > now.w + next.w){
                    dist[next.to] = now.w + next.w;
                    pQ.offer(new Node(next.to,now.w + next.w));
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(i!=start && dist[i] <=threshold) cnt++;
        }

        return cnt;

    }
}