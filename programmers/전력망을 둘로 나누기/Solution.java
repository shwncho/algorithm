import java.util.*;
class Solution {
    static int answer=Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void BFS(int s1, int s2,int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s1);
        visited[s1]=true;
        int cnt=0;
        while(!q.isEmpty()){
            int x = q.poll();

            for(int nx : graph.get(x)){
                if((x==s1 && nx==s2) || (x==s2 && nx==s1))    continue;
                if(!visited[nx]){
                    visited[nx]=true;
                    q.offer(nx);
                    cnt++;
                }
            }
        }

        answer=Math.min(answer,Math.abs(cnt-(n-cnt-1)));

    }
    public int solution(int n, int[][] wires) {

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<n-1; i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }

        for(int i=0; i<n-1; i++){
            visited = new boolean[n+1];
            BFS(wires[i][0],wires[i][1], n-1);
        }
        return answer;
    }


}