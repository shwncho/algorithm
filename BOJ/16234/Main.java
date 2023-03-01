import java.util.*;
import java.io.*;
class Point{
    public int x,y;
    Point(int x,  int y){
        this.x=x;
        this.y=y;
    }
}
public class Main{
    static int n,L,R;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution());
    }

    public static int solution(){
        int time = 0;
        while(true){
            flag=false;
            visited=new boolean[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j]){
                        BFS(i,j);
                    }
                }
            }
            if(!flag)    break;
            time++;
        }

        return time;
    }

    public static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        ArrayList<Point> list = new ArrayList<>();
        q.offer(new Point(x,y));
        list.add(new Point(x,y));

        visited[x][y]=true;

        //연합 인구수
        int sum=map[x][y];
        //연합의 수
        int countryCnt = 1;
        while(!q.isEmpty()){
            Point p = q.poll();

            int cx = p.x;
            int cy = p.y;

            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)    continue;

                if(!visited[nx][ny] && valid(cx,cy,nx,ny)){
                    sum+=map[nx][ny];
                    countryCnt++;
                    visited[nx][ny]=true;
                    q.offer(new Point(nx,ny));
                    list.add(new Point(nx,ny));
                }
            }
        }
        //국가 간 이동이 있는 경우
        if(countryCnt!=1){
            flag=true;
            //연합간 나누어지는 인구 수
            int num=sum/countryCnt;
            for(Point p : list){
                map[p.x][p.y]=num;
            }

        }
    }

    public static boolean valid(int x, int y, int nx, int ny){
        int value = Math.abs(map[x][y]-map[nx][ny]);
        return L <= value && value <= R;
    }
}