import java.util.*;
import java.io.*;
class Point{
    public int x,y,cnt;
    public boolean flag;

    Point(int x,int y,int cnt, boolean flag){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
        this.flag=flag;
    }
    Point(){
        this.x=0;
        this.y=0;
        this.cnt=0;
        this.flag=false;
    }
}
public class Main {
    static int n,m;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph=new int[n][m];
        visited=new boolean[n][m][2];
        st= new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken())-1;
        int sy = Integer.parseInt(st.nextToken())-1;

        Point s = new Point(sx,sy,0,false);

        st=new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken())-1;
        int ey = Integer.parseInt(st.nextToken())-1;
        Point e = new Point(ex,ey,0,false);

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS(s,e));


    }

    public static int BFS(Point s, Point e){
        Queue<Point> q = new LinkedList<>();
        q.offer(s);
        visited[s.x][s.y][0]=true;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0; i<len ;i++){
                Point p = q.poll();

                if(p.x==e.x && p.y==e.y)    return p.cnt;

                for(int j=0; j<4; j++){
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if(nx<0 || nx>=n || ny<0 || ny>=m)  continue;

                    if(graph[nx][ny]==0){
                        //벽을 부순적이 없을경우
                        if(!visited[nx][ny][0] && !p.flag){
                            visited[nx][ny][0]=true;
                            q.offer(new Point(nx,ny,p.cnt+1,false));
                        }
                        //벽을 부순적이 있을경우
                        else if(!visited[nx][ny][1] && p.flag){
                            visited[nx][ny][1]=true;
                            q.offer(new Point(nx,ny,p.cnt+1,true));
                        }
                    }

                    else if(graph[nx][ny]==1){
                        if(!visited[nx][ny][1] && !p.flag){
                            visited[nx][ny][1]=true;
                            q.offer(new Point(nx,ny,p.cnt+1,true));
                        }
                    }
                }
            }
        }



        return -1;
    }
}
