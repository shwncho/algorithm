import java.util.*;
import java.io.*;
class Point{
    public int x,y,cnt;
    Point(int x, int y,int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}
public class Main{
    static int r,c;
    static char[][] graph;
    static boolean[][] visited;
    static boolean[][] wVisited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Point> waters = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        graph=new char[r][c];
        visited=new boolean[r][c];
        wVisited = new boolean[r][c];

        Point s = new Point(0,0,0);
        Point d = new Point(0,0,0);
        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                graph[i][j]=str.charAt(j);
                if(graph[i][j]=='S')    s=new Point(i,j,0);
                else if(graph[i][j]=='D')    d=new Point(i,j,0);
                else if(graph[i][j]=='*')   waters.add(new Point(i,j,0));
            }
        }

        int result = BFS(s,d);

        System.out.println(result==-1 ? "KAKTUS" : result);
    }

    public static int BFS(Point s, Point d){
        Queue<Point> q = new LinkedList<>();
        Queue<Point> wq = new LinkedList<>();
        for(Point p : waters){
            wq.offer(new Point(p.x,p.y,0));
            wVisited[p.x][p.y]=true;
        }
        q.offer(new Point(s.x,s.y,0));
        visited[s.x][s.y]=true;

        while(!q.isEmpty()){
            int wLen = wq.size();
            for(int j=0; j<wLen; j++){
                Point wp = wq.poll();


                int wx = wp.x;
                int wy = wp.y;

                for(int i=0; i<4; i++){
                    int nx = wx+dx[i];
                    int ny = wy+dy[i];

                    if(nx<0 || nx>=r || ny<0 || ny>=c)    continue;

                    if(!wVisited[nx][ny] && graph[nx][ny]=='.'){
                        wVisited[nx][ny]=true;
                        graph[nx][ny]='*';
                        wq.offer(new Point(nx,ny,0));
                    }
                }
            }

            int len = q.size();
            for(int j=0; j<len; j++){
                Point p = q.poll();
                int x = p.x;
                int y = p.y;
                int cnt = p.cnt;

                if(x==d.x && y==d.y){
                    return cnt;
                }

                for(int i=0; i<4; i++){
                    int nx = x+dx[i];
                    int ny = y+dy[i];

                    if(nx<0 || nx>=r || ny<0 || ny>=c)    continue;

                    if(!visited[nx][ny] && (graph[nx][ny]=='.' || graph[nx][ny]=='D')){
                        visited[nx][ny]=true;
                        q.offer(new Point(nx,ny,cnt+1));
                    }

                }
            }
        }

        return -1;
    }
}