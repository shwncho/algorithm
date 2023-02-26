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
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static int n;
    static boolean[][] visited;
    static int answer;
    public static void BFS(Point start, Point end){
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y]=true;
        answer=0;
        while(!q.isEmpty()){
            Point tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;

            if(x==end.x && y==end.y){
                answer=tmp.cnt;
                return;
            }

            for(int i=0; i<8; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)    continue;

                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new Point(nx,ny,tmp.cnt+1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int k=0; k<t; k++){

            n = Integer.parseInt(br.readLine());
            visited=new boolean[n][n];
            Point start=new Point(0,0,0);
            Point end=new Point(0,0,0);
            for(int i=0; i<2; i++){
                st=new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(i==0)    start=new Point(x,y,0);
                else    end=new Point(x,y,0);
            }

            BFS(start,end);

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }
}