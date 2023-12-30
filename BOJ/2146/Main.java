import java.util.*;
import java.io.*;
class Point {
    public int x,y,cnt;
    Point(int x, int y, int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}
public class Main {
    static int n;
    static int[][] graph;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;
    static int landNum = 2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]==1){
                    changeLandNum(i,j);
                    landNum++;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]>=2){
                    visited = new boolean[n][n];
                    BFS(i,j);
                }
            }
        }

        System.out.println(answer);
    }

    static void changeLandNum(int x, int y){
        Queue<Point> q = new LinkedList<>();
        visited[x][y]=true;
        graph[x][y]=landNum;
        q.offer(new Point(x,y,0));

        while(!q.isEmpty()){

            Point tmp = q.poll();

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)  continue;

                if(visited[nx][ny]) continue;

                if(graph[nx][ny]==1){
                    graph[nx][ny]=landNum;
                    visited[nx][ny]=true;
                    q.offer(new Point(nx,ny,0));
                }
            }
        }
    }

    static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y,0));
        visited[x][y]=true;
        int currentLandNum = graph[x][y];

        while(!q.isEmpty()){

            Point tmp = q.poll();

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)  continue;

                if(visited[nx][ny]) continue;

                if(graph[nx][ny]!=currentLandNum){
                    if(graph[nx][ny]==0){
                        visited[nx][ny]=true;
                        q.offer(new Point(nx,ny,tmp.cnt+1));
                    }
                    else answer = Math.min(answer, tmp.cnt);
                }
            }
        }
    }
}
