import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    public int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    static int[][] board,dis;
    static int N,M;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public static void BFS(){
        Queue<Point> Q = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]==1)  Q.offer(new Point(i,j));
            }
        }
        while(!Q.isEmpty()){
            Point cp = Q.poll();
            for(int i=0; i<4; i++){
                int nx = cp.x+dx[i];
                int ny = cp.y+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny]==0){
                    board[nx][ny]=1;
                    Q.offer(new Point(nx,ny));
                    dis[nx][ny]=dis[cp.x][cp.y]+1;
                }
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dis = new int[N][M];
        int max=Integer.MIN_VALUE;
        boolean flag=true;

        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        BFS();

        //단 한 요소라도 0이 있으면 다 안익은경우 이므로
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]==0)  flag=false;
            }
        }

        if(flag) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (dis[i][j] > max) max = dis[i][j];
                }
            }
            System.out.println(max);
        }
        else System.out.println(-1);

    }
}
