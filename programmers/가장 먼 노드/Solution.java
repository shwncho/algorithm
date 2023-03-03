import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dis;
    public static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dis[1]=0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0; i<len; i++){
                int now = q.poll();

                for(int nx : graph.get(now)){

                    if(dis[nx]>dis[now]+1){
                        dis[nx]=dis[now]+1;
                        q.offer(nx);
                    }
                }
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;

        dis = new int[n+1];
        Arrays.fill(dis,1000000000);
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        BFS();

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            max=Math.max(max,dis[i]);
        }

        int cnt=0;
        for(int i=1; i<=n; i++){
            if(max==dis[i]) cnt++;
        }

        answer=cnt;
        return answer;
    }
}