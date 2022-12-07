import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    public int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n,m;
    static int[][] graph;
    static int[][] dis;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        dis[x][y]=1;
        graph[x][y]=0;
        while(!Q.isEmpty()){
            Point cp = Q.poll();
            for(int i=0; i<4; i++){
                int nx = cp.x+dx[i];
                int ny = cp.y+dy[i];
                if(nx>=1 && nx<=n && ny>=1 && ny<=m && graph[nx][ny]==1){
                    //다음 방문 x,y 좌표를 미리 방문 표시해줌으로써 최소 방문을 보장
                    graph[nx][ny]=0;
                    Q.offer(new Point(nx,ny));
                    dis[nx][ny]=dis[cp.x][cp.y]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        graph= new int[n+1][m+1];
        dis= new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            // 숫자들이 공백으로 띄어져 있지 않고 붙어있을경우는 nextInt로 못받는다.
            String str = br.readLine();
            for(int j=1; j<=m; j++){
                graph[i][j]=str.charAt(j-1)-'0';
            }
        }


        BFS(1,1);
        System.out.println(dis[n][m]);
    }
}
