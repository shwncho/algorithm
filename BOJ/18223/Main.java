import java.util.*;
import java.io.*;
class Edge implements Comparable<Edge>{
    public int vex,cost;
    Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}
public class Main {
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int friendVertex = Integer.parseInt(st.nextToken());

        dis = new int[V+1];
        for(int i=0; i<V+1; i++){
            dis[i] = Integer.MAX_VALUE;
        }
        graph = new ArrayList<>();
        for(int i=0; i<V+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }

        BFS(1);

        int minDistance = dis[V];

        int friendDistance = dis[friendVertex];
        dis = new int[V+1];
        for(int i=0; i<V+1; i++){
            dis[i] = Integer.MAX_VALUE;
        }

        BFS(friendVertex);

        friendDistance+=dis[V];


        System.out.println(friendDistance<=minDistance ? "SAVE HIM" : "GOOD BYE");
    }

    private static void BFS(int v){
        Queue<Edge> pQ = new PriorityQueue<>();
        dis[v]=0;
        pQ.offer(new Edge(v,0));
        while(!pQ.isEmpty()){
            Edge now = pQ.poll();
            if(now.cost > dis[now.vex]) continue;
            for(Edge next : graph.get(now.vex)){
                if(dis[next.vex] > now.cost + next.cost){
                    dis[next.vex] = now.cost + next.cost;
                    pQ.offer(new Edge(next.vex, now.cost + next.cost));
                }
            }
        }
    }
}
