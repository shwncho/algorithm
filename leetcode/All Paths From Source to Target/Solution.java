class Solution {
    static class Node {
        int idx;
        List<Integer> route;

        Node(int idx, List<Integer> route) {
            this.idx = idx;
            this.route = route;
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();

        for(int i=0; i<graph[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(graph[0][i]);
            q.offer(new Node(graph[0][i],list));
        }

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.idx == n-1) {
                answer.add(now.route);
                continue;
            }
            else {
                for(int i : graph[now.idx]) {
                    List<Integer> tmp = new ArrayList<>(now.route);
                    tmp.add(i);
                    Node next = new Node(i, tmp);
                    q.offer(next);
                }
            }

        }

        return answer;
    }
}