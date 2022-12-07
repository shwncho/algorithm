import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;
    Edge(int vex, int cost){
        this.vex=vex;
        this.cost=cost;
    }

    @Override
    public int compareTo(Edge o){
        return this.cost-o.cost;
    }
}
public class Main {
    static int n,m;
    static long dis[];
    static ArrayList<ArrayList<Edge>>graph;
    static boolean solution(int v){
        dis[v]=0;

        //n-1번 반복
        for(int i=1; i<n; i++){
            for(int j=1; j<graph.size(); j++){
                for(Edge o : graph.get(j)){
                    if(dis[j]!=Integer.MAX_VALUE && dis[o.vex]>dis[j]+o.cost){
                        dis[o.vex]=dis[j]+o.cost;
                    }
                }
            }
        }

        for(int i=1; i<graph.size(); i++){
            for(Edge o : graph.get(i)){
                if(dis[i]!=Integer.MAX_VALUE && dis[o.vex]>dis[i]+o.cost){
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dis=new long[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        graph=new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b,c));
        }

        StringBuilder sb = new StringBuilder();
        if(solution(1)){
            for(int i=2; i<=n; i++){
                if(dis[i]==Integer.MAX_VALUE)   sb.append("-1\n");
                else sb.append(dis[i]+"\n");
            }
        }
        else sb.append("-1\n");


        System.out.println(sb.toString());



    }
}
