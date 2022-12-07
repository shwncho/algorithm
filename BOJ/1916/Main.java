import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;
    Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o){
        return this.cost-o.cost;
    }
}

public class Main {
    static int n,m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    static void solution(int start){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(start,0));
        dis[start]=0;
        while(!pQ.isEmpty()){
            Edge tmp =pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost>dis[now])    continue;
            for(Edge o : graph.get(now)){
                if(dis[o.vex]>nowCost+o.cost){
                    dis[o.vex]=nowCost+o.cost;
                    pQ.offer(new Edge(o.vex, nowCost+o.cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        dis=new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            int a= sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        solution(start);

        System.out.println(dis[end]);

    }
}
