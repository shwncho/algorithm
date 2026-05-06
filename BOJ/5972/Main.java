import java.io.*;
import java.util.*;
public class Main {
    static class Edge implements Comparable<Edge> {
        int vex;
        int cost;

        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++)  graph.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }

        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        Queue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1,0));
        dis[1]=0;

        while(!pQ.isEmpty()){
            Edge now = pQ.poll();
            if(dis[now.vex] < now.cost) continue;

            for(Edge next : graph.get(now.vex)){
                if(dis[next.vex] > now.cost + next.cost) {
                    dis[next.vex] = now.cost + next.cost;
                    pQ.offer(new Edge(next.vex, now.cost + next.cost));
                }
            }
        }

        System.out.println(dis[N]);


    }
}
