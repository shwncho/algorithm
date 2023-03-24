import java.util.*;
import java.io.*;
class Point{
    public int x,y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main{
    static int n,m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int cheese=0;
    static ArrayList<Point> cheeseList = new ArrayList<>();

    public static void BFS(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0));
        visited[0][0]=true;
        graph[0][0]=2;

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(graph[nx][ny]==1 || visited[nx][ny]) continue;

                graph[nx][ny]=2;
                visited[nx][ny]=true;
                q.offer(new Point(nx,ny));
            }
        }


    }

    public static void melting(){
        for(int i=0; i<cheeseList.size(); i++){
            int x = cheeseList.get(i).x;
            int y = cheeseList.get(i).y;
            int cnt=0;

            for(int j=0; j<4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if(graph[nx][ny]==2)    cnt++;

            }

            if(cnt>=2){
                graph[x][y]=0;
                cheese--;
                cheeseList.remove(i);
                i--;
            }

        }
    }

    public static void solution(){
        int time=0;

        while(cheese!=0){
            time++;
            visited=new boolean[n][m];
            //외부공기,내부공기 구분해서 녹일 수 있는지 판단하는 것이 핵심
            BFS();
            melting();
        }

        System.out.println(time);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(graph[i][j]==1){
                    cheese++;
                    cheeseList.add(new Point(i,j));
                }
            }
        }

        solution();

    }
}