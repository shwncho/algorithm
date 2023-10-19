import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    public int vex;
    public long cost;
    Edge(int vex, long cost){
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return Long.compare(this.cost, o.cost);
    }
}
public class Main {
    static int N,M;
    static int[] seen;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static long[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)  graph.add(new ArrayList<>());
        dis = new long[N];
        Arrays.fill(dis, Long.MAX_VALUE);
        seen = new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  seen[i]=Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e,t));
            graph.get(e).add(new Edge(s,t));
        }

        System.out.println(BFS());

    }

    public static long BFS(){
        Queue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(0,0));
        dis[0]=0;
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();

            if(tmp.vex==N-1)    return tmp.cost;

            if(tmp.cost > dis[tmp.vex]) continue;

            for(Edge next : graph.get(tmp.vex)){
                if(next.vex!=N-1 && seen[next.vex]==1) continue;
                if(dis[next.vex] > tmp.cost + next.cost){
                    dis[next.vex] = tmp.cost + next.cost;
                    pQ.offer(new Edge(next.vex, tmp.cost + next.cost));
                }
            }
        }

        return -1;
    }
}
