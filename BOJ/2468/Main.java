import java.util.*;
import java.io.*;
class Point{
    public int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Main{
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int answer=Integer.MIN_VALUE;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int r=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph= new int[n][n];

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                max=Math.max(max,graph[i][j]);
            }
        }

        for(int i=0; i<=max; i++){
            solution(i);
        }
        System.out.println(answer);
    }
    public static void solution(int k){
        r=k;
        visited= new boolean[n][n];
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]<=r)  visited[i][j]=true;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    BFS(i,j);
                    cnt++;
                }
            }
        }
        answer=Math.max(answer,cnt);

    }
    public static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visited[x][y]=true;

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)    continue;

                if(!visited[nx][ny] && graph[nx][ny]>r){
                    visited[nx][ny]=true;
                    q.offer(new Point(nx,ny));
                }
            }
        }
    }
}