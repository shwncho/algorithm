import java.util.*;
import java.io.*;
class Point{
    public int x,y;

    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Main{
    static int r,c,n;
    static char[][] graph;
    static int[][] dis;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        dis = new int[r][c];

        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                graph[i][j]=s.charAt(j);
                if(graph[i][j]=='O')    dis[i][j]=1;
            }
        }
        int time=1;
        while(time<=n){

            if(time%2==0)  fill();
            else    boom();

            timeUp();
            time++;

        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void boom(){
        visited = new boolean[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(!visited[i][j] && dis[i][j]>=3 && graph[i][j]=='O'){
                    BFS(i,j);
                }
            }
        }
    }

    public static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visited[x][y]=true;
        dis[x][y]=0;
        graph[x][y]='.';
        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || nx>=r || ny<0 || ny>=c)    continue;

                if(!visited[nx][ny] && graph[nx][ny]=='O' && dis[nx][ny]<3){
                    visited[nx][ny]=true;
                    dis[nx][ny]=0;
                    graph[nx][ny]='.';
                }
            }
        }
    }

    public static void fill(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(graph[i][j]=='.'){
                    graph[i][j]='O';
                    dis[i][j]=1;
                }
            }
        }
    }
    public static void timeUp(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(graph[i][j]=='O'){
                    dis[i][j]+=1;
                }
            }
        }
    }
}