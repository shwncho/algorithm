import java.io.*;
import java.util.*;
class Edge implements Comparable<Edge>{
    public int time;
    public int idx;
    Edge(int time, int idx){
        this.time = time;
        this.idx = idx;
    }

    @Override
    public int compareTo(Edge o){
        if(this.time == o.time) return this.idx - o.idx;
        return this.time - o.time;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int INF = 10_000_000;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                graph[i][j] = i==j ? 0 : INF;
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b]=c;
        }


        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Edge> pQ = new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            int maxi = 0;
            for(int j=0; j<K; j++){
                maxi = Math.max(maxi, graph[arr[j]][i] + graph[i][arr[j]]);
            }
            pQ.offer(new Edge(maxi, i));

        }

        StringBuilder sb = new StringBuilder();
        int min = pQ.peek().time;
        while(!pQ.isEmpty() && min == pQ.peek().time){
            sb.append(pQ.poll().idx).append(" ");
        }

        System.out.println(sb);



    }
}
