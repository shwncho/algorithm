import java.util.*;
import java.io.*;
class Point implements Comparable<Point>{
    public int x,y,cost;
    Point(int x,int y,int cost){
        this.x=x;
        this.y=y;
        this.cost=cost;
    }

    @Override
    public int compareTo(Point p){
        return this.cost-p.cost;
    }
}
public class Main{
    static int n,m;
    static int[][] graph;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer=Integer.MAX_VALUE;
    static boolean[][] visited;
    public static void BFS(int x, int y){
        PriorityQueue<Point> q = new PriorityQueue<>();
        visited[x][y]=true;
        q.offer(new Point(x,y,0));
        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x==n-1 && p.y==m-1){
                answer=p.cost;
                return;
            }
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)  continue;

                if(!visited[nx][ny] && graph[nx][ny]==0){
                    visited[nx][ny]=true;
                    q.offer(new Point(nx,ny,p.cost));
                }
                else if(!visited[nx][ny] && graph[nx][ny]==1){
                    visited[nx][ny]=true;
                    q.offer(new Point(nx,ny,p.cost+1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph= new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j]=Integer.parseInt(s.substring(j,j+1));
            }
        }
        BFS(0,0);
        System.out.println(answer);


    }
}