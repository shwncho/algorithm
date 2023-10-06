import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    public int vex;
    public long cost;

    Point(int vex, long cost){
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Point p){
        return Long.compare(this.cost, p.cost);
    }
}

public class Main {
    static ArrayList<ArrayList<Point>> graph = new ArrayList<>();
    static long[] dis;
    static boolean[][] checked;
    static Set<Integer> mSet = new HashSet<>();
    static Set<Integer> sSet = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int MAX_INT = 100_000_000;

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for(int i=0; i<=V+2; i++) graph.add(new ArrayList<>());

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(v).add(new Point(u,w));
            graph.get(u).add(new Point(v,w));

        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        mSet.add(V+1);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int value = Integer.parseInt(st.nextToken());
            mSet.add(value);
            //가상의 V+1 맥도날드
            graph.get(V+1).add(new Point(value,0));
        }


        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        sSet.add(V+2);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<S; i++){
            int value = Integer.parseInt(st.nextToken());
            sSet.add(value);
            //가상의 V+2 스타벅스
            graph.get(V+2).add(new Point(value,0));
        }

        long[] result = new long[V+1];
        dis = new long[V+3];
        checked = new boolean[V+3][V+3];
        Arrays.fill(result, MAX_INT);
        Arrays.fill(dis, MAX_INT);
        BFS(V+1);
        for(int i=1; i<=V; i++){
            if(mSet.contains(i) || sSet.contains(i)){
                continue;
            }

            if(dis[i]<=x){
                result[i] = dis[i];
            }

        }

        dis = new long[V+3];
        checked = new boolean[V+3][V+3];
        Arrays.fill(dis, MAX_INT);
        BFS(V+2);
        for(int i=1; i<=V; i++){
            if(mSet.contains(i) || sSet.contains(i))    continue;

            if(dis[i]<=y){
                result[i] += dis[i];
            }
            else result[i] +=MAX_INT;
        }

        long answer = Integer.MAX_VALUE;
        for(long value : result){
            if(value<MAX_INT && answer > value) {
                answer = value;
            }
        }

        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
    }


    public static void BFS(int s){
        PriorityQueue<Point> pQ = new PriorityQueue<>();
        pQ.offer(new Point(s,0));
        dis[s]=0;
        while(!pQ.isEmpty()){
            Point c = pQ.poll();
            int cv = c.vex;
            long cost = c.cost;

            if(cost > dis[cv])  continue;

            for(Point np : graph.get(cv)){
                int next = np.vex;
                long nextCost = np.cost;
                if(dis[next] > cost + nextCost && !checked[cv][next]){
                    dis[next] = cost + nextCost;
                    checked[cv][next]=true;
                    pQ.offer(new Point(np.vex, cost+nextCost));
                }
            }
        }


    }
}
