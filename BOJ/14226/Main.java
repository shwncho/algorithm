import java.util.*;
import java.io.*;
class Point{
    public int x,save,cnt;
    Point(int x, int save, int cnt){
        this.x=x;
        this.save=save;
        this.cnt=cnt;
    }
}
public class Main{
    public static int BFS(int n){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(1,0,0));
        boolean[][] visited = new boolean[1001][1001];
        visited[1][0]=true;
        while(!q.isEmpty()){
            Point tmp = q.poll();

            int x = tmp.x;
            int save = tmp.save;
            int cnt =tmp.cnt;

            if(x==n)  return cnt;

            //복사
            q.offer(new Point(x,x,cnt+1));


            //붙여넣기
            if(save!=0 && x+save<=1000 && !visited[x][x+save]){
                visited[x][x+save]=true;
                q.offer(new Point(x+save,save,cnt+1));
            }
            //삭제
            if(2<=x-1 && !visited[x-1][save]){
                visited[x-1][save]=true;
                q.offer(new Point(x-1,save,cnt+1));
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(BFS(n));

    }
}