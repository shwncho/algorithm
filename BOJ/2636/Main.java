import java.util.*;
import java.io.*;
class Point{
    public int x,y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main{
    static int n,m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int cheese=0;

    public static void BFS(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0));
        visited[0][0]=true;

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

                if(!visited[nx][ny]){
                    visited[nx][ny]=true;

                    if(graph[nx][ny]==0){
                        q.offer(new Point(nx,ny));
                    }
                    else if(graph[nx][ny]==1){
                        graph[nx][ny]=0;
                        cheese--;
                    }
                }
            }
        }


    }

    public static void solution(){
        int time=0;
        int lastCheese=0;

        while(cheese!=0){
            //지우기 전 마지막 치즈 개수
            lastCheese=cheese;
            time++;
            visited=new boolean[n][m];
            BFS();
        }

        System.out.println(time);
        System.out.println(lastCheese);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(graph[i][j]==1)    cheese++;
            }
        }

        solution();

    }
}