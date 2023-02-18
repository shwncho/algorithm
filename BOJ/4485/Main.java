import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    public int x,y,cost;
    Edge(int x, int y, int cost){
        this.x=x;
        this.y=y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}
public class Main{
    static int[][] graph;
    static int[][] dis;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    public static int BFS(){
        dis[0][0]=graph[0][0];
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(0,0,graph[0][0]));
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int x = tmp.x;
            int y = tmp.y;
            int cost = tmp.cost;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n)    continue;

                if(dis[nx][ny] > graph[nx][ny]+cost){
                    dis[nx][ny] = graph[nx][ny]+cost;
                    pQ.offer(new Edge(nx,ny,graph[nx][ny]+cost));
                }
            }
        }
        return dis[n-1][n-1];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int idx=0;
        while(true){
            idx++;
            n = Integer.parseInt(br.readLine());

            if(n==0)    break;

            graph=new int[n][n];
            dis=new int[n][n];
            for(int i=0; i<n; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    graph[i][j]=Integer.parseInt(st.nextToken());
                    dis[i][j]=Integer.MAX_VALUE;
                }
            }

            sb.append("Problem " +idx+": ").append(BFS()).append("\n");

        }
        System.out.println(sb);
    }
}