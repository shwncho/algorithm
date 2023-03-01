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
    static int n,m;
    static int[][] graph;
    static int answer = Integer.MAX_VALUE;
    static boolean[][] virus;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Point> virusList = new ArrayList<>();
    static int emptyCnt=0;
    public static int BFS(){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        for(Point p : virusList){
            if(virus[p.x][p.y]){
                visited[p.x][p.y]=true;
                q.offer(new Point(p.x,p.y,0));
            }
        }

        int max = 0;
        int zeroCnt = 0;

        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            int cnt = p.cnt;


            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)  continue;

                if(visited[nx][ny] || graph[nx][ny]==1) continue;

                if(graph[nx][ny]==0){
                    zeroCnt++;
                    max=cnt+1;
                }

                visited[nx][ny]=true;
                q.offer(new Point(nx,ny,cnt+1));

            }
        }

        if(zeroCnt==emptyCnt){
            return max;
        }
        return Integer.MAX_VALUE;


    }

    public static void DFS(int L, int s){
        if(L==m){
            answer=Math.min(answer,BFS());
        }
        else{
            for(int i=s; i<virusList.size(); i++){
                int x = virusList.get(i).x;
                int y = virusList.get(i).y;
                if(!virus[x][y]){
                    virus[x][y]=true;
                    DFS(L+1,i+1);
                    virus[x][y]=false;
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

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(graph[i][j]==0)  emptyCnt++;
                else if(graph[i][j]==2)  virusList.add(new Point(i,j,0));
            }
        }

        DFS(0,0);

        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);

    }
}
