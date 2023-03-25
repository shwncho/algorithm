import java.util.*;
import java.io.*;
class Point{
    public int x,y,cnt;
    public int flag;
    Point(int x, int y, int cnt, int flag){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
        //벽을 부순 횟수
        this.flag=flag;
    }
}
public class Main{
    static int n,m,k;
    static int[][] graph;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer=Integer.MAX_VALUE;
    static boolean[][][] visited;
    public static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y,1,0));
        visited[x][y][0]=true;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x==n-1 && p.y==m-1){
                answer=p.cnt;
                return;
            }
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)  continue;

                //벽이 아닐 때
                if(graph[nx][ny]==0 && !visited[nx][ny][p.flag]){
                    visited[nx][ny][p.flag]=true;
                    q.offer(new Point(nx,ny,p.cnt+1,p.flag));
                }
                else if(graph[nx][ny]==1 && p.flag<k && !visited[nx][ny][p.flag+1]){
                    visited[nx][ny][p.flag+1]=true;
                    q.offer(new Point(nx,ny,p.cnt+1,p.flag+1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph= new int[n][m];

        for(int i=0;i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j]=s.charAt(j)-'0';
            }
        }
        visited=new boolean[n][m][k+1];
        BFS(0,0);

        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
    }
}