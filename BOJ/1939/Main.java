import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    public int vex;
    public int weight;
    Edge(int vex, int weight){
        this.vex=vex;
        this.weight=weight;
    }

    @Override
    public int compareTo(Edge o){
        return o.weight - this.weight;
    }
}
public class Main {
    static int n,m;
    static int[] w;
    static ArrayList<ArrayList<Edge>> graph;
    //overflow생기는 상황이 아니면 Integer.MAX_VALUE로 할당하자
    static final int INF = Integer.MAX_VALUE;

    static void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v,INF));
        w[v]=INF;
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowWeight = tmp.weight;
            if(w[now]>nowWeight)    continue;

            for(Edge next : graph.get(now)){
                int nextVex = next.vex;
                int nextWeight = Math.min(nowWeight, next.weight);
                if(w[nextVex]<nextWeight){
                    w[nextVex]=nextWeight;
                    pQ.offer(new Edge(nextVex, nextWeight));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph=new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        w=new int[n+1];
        Arrays.fill(w,-1);

        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }

        st=new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        solution(A);

        System.out.println(w[B]);





    }
}
