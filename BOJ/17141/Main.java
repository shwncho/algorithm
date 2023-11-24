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
    static int n,m;
    static int[][] graph;
    static int answer = Integer.MAX_VALUE;
    static boolean[][] virus;
    static boolean[][] wall;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static ArrayList<Point> virusList = new ArrayList<>();
    public static void BFS(){
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[n][n];

        int[][] copyGraph = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                copyGraph[i][j]=graph[i][j];

                if(virus[i][j]) {
                    q.offer(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int max = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x;
            int y = p.y;

            max = Math.max(max,copyGraph[x][y]);

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && !wall[nx][ny]){
                    copyGraph[nx][ny] = copyGraph[x][y]+1;
                    visited[nx][ny]=true;
                    q.offer(new Point(nx,ny));
                }
            }
        }
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                //방문하지않고 0인곳 or 방문하지않고 바이러스를 놓을 수 있었던 곳
                if (!visited[i][j] && (copyGraph[i][j] == 0 || copyGraph[i][j]==2)){
                    max = Integer.MAX_VALUE;
                    break;
                }
            }
        }
        answer = Math.min(answer,max);

    }

    public static void DFS(int L, int s){
        if(L==m){
            BFS();
        }
        else{
            for(int i=s; i<virusList.size(); i++){
                int x = virusList.get(i).x;
                int y = virusList.get(i).y;
                if(!virus[x][y]){
                    graph[x][y]=0;
                    virus[x][y]=true;
                    DFS(L+1,i+1);
                    virus[x][y]=false;
                    graph[x][y]=2;

                }
            }

        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        virus = new boolean[n][n];
        wall = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(graph[i][j]==1)  wall[i][j]=true;
                if(graph[i][j]==2)  virusList.add(new Point(i,j));
            }
        }

        DFS(0,0);

        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);


    }
}
