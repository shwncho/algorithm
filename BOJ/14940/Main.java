import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point{
    public int x,y,cnt;
    Point(int x, int y, int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}
public class Main {
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] graph,visited,answer;
    static int ex,ey;
    public static int BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y,0));
        visited[x][y]=1;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0; i<len; i++){
                Point p = q.poll();
                for(int j=0; j<4; j++){
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if(nx<0 || nx>=n || ny<0 || ny>=m)  continue;
                    if(visited[nx][ny]==1 || graph[nx][ny]==0)  continue;

                    visited[nx][ny]=1;
                    q.offer(new Point(nx,ny,p.cnt+1));
                    answer[nx][ny]=p.cnt+1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new int[n][m];
        answer = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(graph[i][j]==2){
                    ex=i;
                    ey=j;
                }
            }
        }

        BFS(ex,ey);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j]==1 && visited[i][j]==0){
                    sb.append(-1).append(" ");
                }
                else sb.append(answer[i][j]).append(" ");

            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
}
