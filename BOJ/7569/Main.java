import java.util.*;
import java.io.*;

class Point{
    public int h,x,y;

    Point(int h, int x, int y){
        this.h = h;
        this.x = x;
        this.y= y;
    }
}

public class Main{
    static int n,m,h;
    static int[][][] graph;
    static boolean[][][] visited;
    static int[][][] dis;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] dh = {-1,1};
    static ArrayList<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        graph = new int[h][n][m];
        visited = new boolean[h][n][m];
        dis = new int[h][n][m];

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    graph[i][j][k]=Integer.parseInt(st.nextToken());
                    if(graph[i][j][k]==1)   list.add(new Point(i,j,k));
                }
            }
        }

        BFS();
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(graph[i][j][k]==0){
                        System.out.println(-1);
                        System.exit(0);
                    }

                    answer=Math.max(answer,dis[i][j][k]);

                }
            }
        }
        System.out.println(answer);
    }

    public static void BFS(){
        Queue<Point> q = new LinkedList<>();

        for(Point p : list){
            q.offer(p);
            visited[p.h][p.x][p.y]=true;
        }

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)  continue;

                if(!visited[p.h][nx][ny] && graph[p.h][nx][ny]==0){
                    visited[p.h][nx][ny]=true;
                    graph[p.h][nx][ny]=1;
                    q.offer(new Point(p.h,nx,ny));
                    dis[p.h][nx][ny]=dis[p.h][p.x][p.y]+1;
                }
            }

            for(int i=0; i<2; i++){
                int nh = p.h + dh[i];

                if(nh<0 || nh>=h)   continue;

                if(!visited[nh][p.x][p.y] && graph[nh][p.x][p.y]==0){
                    visited[nh][p.x][p.y]=true;
                    graph[nh][p.x][p.y]=1;
                    q.offer(new Point(nh,p.x,p.y));
                    dis[nh][p.x][p.y]=dis[p.h][p.x][p.y]+1;
                }
            }

        }
    }
}