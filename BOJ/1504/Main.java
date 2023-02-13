import java.util.*;
import java.io.*;
class Edge implements Comparable<Edge>{
    public int vex,cost;
    Edge(int vex, int cost){
        this.vex= vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}
public class Main {
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] dis;
    //INF값 결정하는 것도 영향을 미친다. ( n log n => 최악의 경우 약 800 * log 800 , 최대 비용 1000  => 약 3 * 10^6 이므로
    // INF는 최소 10^7로 설정
    static final int INF = 10000000;
    public static int solution(int v, int e){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        Arrays.fill(dis,INF);
        dis[v]=0;
        pQ.offer(new Edge(v,0));

        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();

            int now = tmp.vex;
            int nowCost = tmp.cost;

            if(nowCost>dis[now])    continue;

            for(Edge o : graph.get(now)){
                if(dis[o.vex] > nowCost + o.cost){
                    dis[o.vex] = nowCost + o.cost;
                    pQ.offer(new Edge(o.vex, nowCost + o.cost));
                }
            }
        }
        return dis[e];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dis = new int[n+1];
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<e; i++){
            st=new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }

        st=new StringTokenizer(br.readLine());

        int t1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());

        /**
         * 1 -> t1 과 1 -> t2 중 작은 경로로 나뉘어서 계산했었으나 이 부분만 계산하면 뒤 계산에서 더 작은 결과가 나오는 것을 고려못함
         * 그러므로 1 -> t1 -> t2 -> n , 1 -> t2 -> t1 -> n 으로 총 결과값 비교하여 작은 값 할당
         */
        int answer = Math.min(solution(1,t1)+solution(t1,t2)+solution(t2,n),
                solution(1,t2)+solution(t2,t1)+solution(t1,n));

        if(answer>=INF) System.out.println(-1);
        else System.out.println(answer);

    }
}
