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
        return this.cost - o.cost;
    }
}
public class Main {
    static int n,m;
    static void solution(int start, ArrayList<ArrayList<Edge>> list, int[] arr){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(start,0));
        arr[start]=0;
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost>arr[now])    continue;
            for(Edge o : list.get(now)){
                if(arr[o.vex]>nowCost+o.cost){
                    arr[o.vex]=nowCost+o.cost;
                    pQ.offer(new Edge(o.vex, nowCost+o.cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int start = sc.nextInt();

        ArrayList<ArrayList<Edge>> graph;
        ArrayList<ArrayList<Edge>> reverseGraph;

        int[] dis1=new int[n+1];
        int[] dis2=new int[n+1];

        Arrays.fill(dis1,Integer.MAX_VALUE);
        Arrays.fill(dis2,Integer.MAX_VALUE);
        graph=new ArrayList<>();
        reverseGraph=new ArrayList<>();

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int s= sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            graph.get(s).add(new Edge(e,c));
            reverseGraph.get(e).add(new Edge(s,c));
        }
        solution(start,graph,dis1);
        solution(start,reverseGraph,dis2);

        int answer = -1;
        for(int i=1; i<=n; i++){
            answer = Math.max(answer, dis1[i]+dis2[i]);
        }


        System.out.println(answer);


    }
}
