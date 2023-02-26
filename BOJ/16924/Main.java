import java.util.*;
import java.io.*;
class Point{
    public int x,y,cnt;

    Point(int x, int y, int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}
public class Main{
    static int n,m;
    static char[][] graph;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    //십자가 최대 크기
    static int s;
    static boolean[][] visited;
    static ArrayList<Point> answer = new ArrayList<>();
    public static void DFS(int x, int y){
        //길이 k
        for(int k=1; k<=s; k++){
            //십자가 형성 여부 flag
            boolean flag=true;
            for(int i=0; i<4; i++){
                int nx = x+dx[i]*k;
                int ny = y+dy[i]*k;

                if(nx>=0 && nx<n && ny>=0 &&ny<m && graph[nx][ny]=='*')    continue;
                else{
                    flag=false;
                    break;
                }
            }
            //십자가 형성 완료
            if(flag){
                answer.add(new Point(x+1,y+1,k));
                visited[x][y]=true;
                for(int i=0; i<4; i++){
                    int nx = x+dx[i]*k;
                    int ny = y+dy[i]*k;

                    visited[nx][ny]=true;
                }
            }
            else break;
        }
    }
    public static void solution(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //교차점 찾기
                if(graph[i][j]=='*'){
                    DFS(i,j);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        s = Math.min(n,m);
        graph = new char[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j]=s.charAt(j);
            }
        }

        solution();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j]=='*' && !visited[i][j]){
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        sb.append(answer.size()).append("\n");
        for(Point p : answer){
            sb.append(p.x+" "+p.y+" "+p.cnt).append("\n");
        }
        System.out.println(sb);


    }
}