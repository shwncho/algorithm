import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    public int vex,cost;
    Edge(int vex, int cost){
        this.vex=vex;
        this.cost=cost;
    }

    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}
public class Main{
    static int n,m,r;
    static int[] item,dis;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    public static void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        dis[v]=0;
        pQ.offer(new Edge(v,0));

        while(!pQ.isEmpty()){
            Edge tmp =  pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;

            if(nowCost > dis[now])    continue;

            for(Edge o : graph.get(now)){
                if(dis[o.vex] > nowCost + o.cost){
                    dis[o.vex] = nowCost + o.cost;
                    pQ.offer(new Edge(o.vex, nowCost+o.cost));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item=new int[n+1];
        dis= new int[n+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            item[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<=n; i++)    graph.add(new ArrayList<>());

        for(int i=0; i<r; i++){
            st=new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }

        int answer=0;
        for(int i=1; i<=n; i++){
            Arrays.fill(dis,Integer.MAX_VALUE);
            solution(i);

            int sum=0;
            for(int j=1; j<=n; j++){
                if(dis[j]<=m)    sum+=item[j];
            }
            answer=Math.max(answer,sum);
        }

        System.out.println(answer);



    }
}