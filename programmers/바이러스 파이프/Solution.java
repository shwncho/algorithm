import java.util.*;
class Solution {
    static class Node {
        int e;
        int t;

        Node(int e, int t) {
            this.e = e;
            this.t = t;
        }
    }
    static List<List<Node>> graph = new ArrayList<>();
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;

        List<Integer> infectionList = new ArrayList<>();
        infectionList.add(infection);
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int[] e : edges) {
            graph.get(e[0]).add(new Node(e[1],e[2]));
            graph.get(e[1]).add(new Node(e[0],e[2]));
        }

        answer = DFS(n,k,infectionList,0);


        return answer;
    }

    private int DFS(int n, int k, List<Integer> infectionList,int cnt) {
        int result = infectionList.size();

        if(cnt==k)  return result;

        for(int type = 1; type <= 3; type++) {

            List<Integer> newList = new ArrayList<>(infectionList);
            boolean[] infected = new boolean[n+1];
            for(int x : infectionList) infected[x] = true;

            Queue<Integer> q = new LinkedList<>();
            for(int x : newList) q.offer(x);

            boolean[] visited = new boolean[n+1];

            while(!q.isEmpty()) {
                int now = q.poll();

                for(Node next : graph.get(now)) {
                    if(next.t == type && !visited[next.e]) {
                        visited[next.e] = true;

                        if(!infected[next.e]) {
                            infected[next.e] = true;
                            newList.add(next.e);
                            q.offer(next.e);
                        }
                    }
                }
            }

            result = Math.max(result, DFS(n,k,newList,cnt+1));
        }


        return result;
    }
}