import java.util.*;
import java.io.*;
class Point{
    public int x,y,cnt;
    public boolean flag;
    Point(int x, int y, int cnt, boolean flag){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
        //벽을 부순 여부
        this.flag=flag;
    }
}
public class Main{
    static int n,m;
    static int[][] graph;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer=Integer.MAX_VALUE;
    static boolean[][][] visited;
    //벽을 부순 경로와 벽을 부수지 않은 경로를 구분해야한다.
    public static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y,1,false));
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
                if(graph[nx][ny]==0){
                    //벽을 부순적 있는 경로
                    if(!visited[nx][ny][1] && p.flag){
                        visited[nx][ny][1]=true;
                        q.offer(new Point(nx,ny,p.cnt+1,true));
                    }
                    //벽을 부순적 없는 경로
                    else if(!visited[nx][ny][0] && !p.flag){
                        visited[nx][ny][0]=true;
                        q.offer(new Point(nx,ny,p.cnt+1,false));
                    }
                }
                else if(graph[nx][ny]==1 && !p.flag){
                    //벽인데 부순적 없으면
                    visited[nx][ny][1]=true;
                    q.offer(new Point(nx,ny,p.cnt+1,true));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph= new int[n][m];

        for(int i=0;i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j]=s.charAt(j)-'0';
            }
        }
        visited=new boolean[n][m][2];
        BFS(0,0);

        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
    }
}