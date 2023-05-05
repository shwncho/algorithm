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
    static int n;
    static int[][] graph,visited;
    static int[] dx = {-2,-2,0,0,2,2};
    static int[] dy =  {-1,1,-2,2,-1,1};
    static int sx,sy,ex,ey;
    public static int BFS(){
        Queue<Point> q = new LinkedList<>();
        visited[sx][sy]=1;
        q.offer(new Point(sx,sy,1));

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                Point p = q.poll();
                for(int j=0; j<6; j++){
                    int nx = p.x+dx[j];
                    int ny = p.y+dy[j];

                    if(nx==ex && ny==ey)    return p.cnt;

                    if(nx<0 || nx>=n || ny<0 || ny>=n) continue;

                    if(visited[nx][ny]==1)  continue;

                    visited[nx][ny]=1;
                    q.offer(new Point(nx,ny,p.cnt+1));

                }
            }
        }


        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        visited = new int[n][n];
        st = new StringTokenizer(br.readLine());

        sx=Integer.parseInt(st.nextToken());
        sy=Integer.parseInt(st.nextToken());
        ex=Integer.parseInt(st.nextToken());
        ey=Integer.parseInt(st.nextToken());


        System.out.println(BFS());




    }
}
