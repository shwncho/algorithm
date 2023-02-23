import java.util.*;
class Solution {
    static int answer=0;
    static boolean[] visited;
    static int k;
    static int[][] graph;
    public static void BFS(int v){
        Queue<Integer> q = new LinkedList<>();
        visited[v]=true;
        q.offer(v);

        while(!q.isEmpty()){
            int x = q.poll();

            for(int i=0; i<k; i++){
                if(x==i)    continue;

                if(!visited[i] && graph[x][i]==1){
                    visited[i]=true;
                    q.offer(i);
                }
            }
        }
        answer++;
    }
    public int solution(int n, int[][] computers) {
        k=n;
        visited = new boolean[n];
        graph = new int[n][n];
        for(int i=0; i<n; i++){
            graph[i]=computers[i].clone();
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                BFS(i);
            }
        }

        return answer;
    }
}