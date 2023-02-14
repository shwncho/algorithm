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
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int answer=0;
    public static void BFS(){
        Queue<Point> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j]==2){
                    q.offer(new Point(i,j));
                }
            }
        }

        int[][] copyGraph = new int[n][m];
        for(int i=0; i<n; i++){
            copyGraph[i]=graph[i].clone();
        }

        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && copyGraph[nx][ny]==0){
                    copyGraph[nx][ny]=2;
                    q.offer(new Point(nx,ny));
                }
            }
        }
        int cnt = countSafeZone(copyGraph);
        answer = Math.max(answer,cnt);

    }
    public static int countSafeZone(int[][] copyGraph){
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyGraph[i][j]==0)    cnt++;
            }
        }
        return cnt;
    }
    public static void DFS(int wallCnt){
        if(wallCnt==3){
            BFS();
        }
        else{
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(graph[i][j]==0){
                        graph[i][j]=1;
                        DFS(wallCnt+1);
                        graph[i][j]=0;
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        DFS(0);

        System.out.println(answer);

    }
}
