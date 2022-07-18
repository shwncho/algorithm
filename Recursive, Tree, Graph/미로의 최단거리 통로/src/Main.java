import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2차원 좌표를 표현하기 위함
class Point{
    public int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] graph;
    static int[][] dis;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Point p = new Point(x,y);
        dis[x][y]=0;
        Q.offer(p);
        while(!Q.isEmpty()){
            Point cp = Q.poll();
            for(int i=0; i<4; i++){
                Point np = new Point(cp.x+dx[i],cp.y+dy[i]);
                if(np.x>=1 && np.x<=7 && np.y>=1 && np.y<=7 && graph[np.x][np.y]==0){
                    graph[cp.x][cp.y]=1;
                    Q.offer(np);
                    dis[np.x][np.y]=dis[cp.x][cp.y]+1;
                }
            }


        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        dis = new int[8][8];

        graph=new int[8][8];

        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                graph[i][j]=sc.nextInt();
            }
        }

        T.BFS(1,1);
        System.out.println(dis[7][7]>0 ? dis[7][7] : -1);

    }
}
