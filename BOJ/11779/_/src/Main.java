import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;
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
    static int n,m;
    static ArrayList<ArrayList<Edge>>graph;
    static int[] dis;
    static int[] route;
    public static void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v,0));
        dis[v]=0;
        route[v]=0;
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost>dis[now])    continue;
            for(Edge o : graph.get(now)){
                if(dis[o.vex]>nowCost+o.cost){
                    dis[o.vex]=nowCost+o.cost;
                    pQ.offer(new Edge(o.vex,nowCost+o.cost));
                    route[o.vex]=now;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        m =sc.nextInt();

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        dis = new int[n+1];
        route= new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            int a =sc.nextInt();
            int b =sc.nextInt();
            int c =sc.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        solution(start);

        System.out.println(dis[end]);

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        int count = 0;
        while(end!=0){
            stk.push(end);
            end=route[end];
            count++;
        }
        System.out.println(count);
        while(!stk.isEmpty()){
            sb.append(stk.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
