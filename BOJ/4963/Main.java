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
    static int n,m;
    static int answer=0;
    static int[][]board;
    static int[] dx={-1,-1,0,1,1,1,0,-1};
    static int[] dy={0,1,1,1,0,-1,-1,-1};
    public static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        while(!Q.isEmpty()){
            Point cp = Q.poll();
            for(int i=0; i<8; i++){
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n && board[nx][ny]==1){
                    board[nx][ny]=0;
                    Q.offer(new Point(nx,ny));
                }
            }
        }
    }
    public static void solution(){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1){
                    answer++;
                    board[i][j]=0;
                    BFS(i,j);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            if(n==0 && m==0)    break;
            board=new int[m][n];

            for(int i=0; i<m; i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    board[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            solution();
            System.out.println(answer);
            answer=0;

        }
    }
}
