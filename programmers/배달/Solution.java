import java.util.*;
import java.io.*;
class Edge implements Comparable<Edge>{
    public int vex, cost;
    Edge(int vex, int cost){
        this.vex=vex;
        this.cost=cost;
    }

    @Override
    public int compareTo(Edge e){
        return this.cost-e.cost;
    }
}
class Solution {
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    //최소거리 기록
    static int[] dis;

    public void BFS(){
        PriorityQueue<Edge> Q = new PriorityQueue<>();
        Q.offer(new Edge(1,0));
        dis[1]=0;

        while(!Q.isEmpty()){
            Edge tmp = Q.poll();
            int now = tmp.vex;
            //지금 vex까지 오는데 누적된 거리
            int nowCost = tmp.cost;

            //현재 지점 누적 비용이 이미 더 적은 값으로 기록되어 있을 경우
            if( nowCost > dis[now]) continue;


            for(Edge o : graph.get(now)){
                if(dis[o.vex] > nowCost+o.cost){
                    dis[o.vex]=nowCost+o.cost;
                    Q.offer(new Edge(o.vex, nowCost+o.cost));
                }
            }


        }

    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        dis= new int[N+1];
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<Edge>());
            dis[i]=Integer.MAX_VALUE;
        }
        for(int i=1; i<=N; i++){

            for(int[] tmp : road){
                int a = tmp[0];
                int b = tmp[1];
                int c = tmp[2];

                graph.get(a).add(new Edge(b,c));
                graph.get(b).add(new Edge(a,c));
            }
        }

        BFS();

        for(int x : dis){
            if(x<=K)    answer++;
        }

        return answer;
    }
}
