import java.util.*;
import java.io.*;
class Point{
    public int l,r,c,cnt;
    Point(int l, int r, int c, int cnt){
        this.l=l;
        this.r=r;
        this.c=c;
        this.cnt=cnt;
    }
    Point(){
        this.l=0;
        this.r=0;
        this.c=0;
        this.cnt=0;
    }
}
public class Main{
    static int L,R,C;
    static char[][][] graph;
    static boolean[][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] dl = {-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        while(true){
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L==0 && R==0 && C==0)    break;

            graph = new char[L][R][C];
            visited = new boolean[L][R][C];

            Point startPoint=new Point();
            Point endPoint=new Point();
            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String s = br.readLine();
                    for(int k=0; k<C; k++){
                        graph[i][j][k]=s.charAt(k);
                        if(graph[i][j][k]=='S')    startPoint=new Point(i,j,k,0);
                        else if(graph[i][j][k]=='E')    endPoint=new Point(i,j,k,0);
                    }
                }

                //빈 공백 제거
                br.readLine();
            }

            int result = BFS(startPoint,endPoint);

            if(result==-1){
                sb.append("Trapped!").append("\n");
            }
            else sb.append("Escaped in " + result +" minute(s).").append("\n");

        }

        System.out.println(sb);


    }
    public static int BFS(Point s, Point e){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(s.l,s.r,s.c,0));
        visited[s.l][s.r][s.c]=true;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.l==e.l && p.r==e.r && p.c == e.c)    return p.cnt;
            //같은 층 탐색
            for(int i=0; i<4; i++){
                int nx = p.r + dx[i];
                int ny = p.c + dy[i];

                if(nx<0 || nx>=R || ny<0 || ny>=C)    continue;

                if(!visited[p.l][nx][ny] && (graph[p.l][nx][ny]=='.' || graph[p.l][nx][ny]=='E')){
                    visited[p.l][nx][ny]=true;
                    q.offer(new Point(p.l,nx,ny,p.cnt+1));
                }
            }

            //다른 층 탐색
            for(int i=0; i<2; i++){
                int nl = p.l + dl[i];

                if(nl<0 || nl>=L)    continue;

                if(!visited[nl][p.r][p.c] && (graph[nl][p.r][p.c]=='.' || graph[nl][p.r][p.c]=='E')){
                    visited[nl][p.r][p.c]=true;
                    q.offer(new Point(nl,p.r,p.c,p.cnt+1));
                }
            }
        }
        //탈출 못할 경우
        return -1;
    }
}