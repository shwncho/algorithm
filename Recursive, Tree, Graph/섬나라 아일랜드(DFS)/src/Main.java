import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer=0;
    static int N;
    static int[][] board;
    static int[] dx={-1,-1,0,1,1,1,0,-1};
    static int[] dy={0,1,1,1,0,-1,-1,-1};
    public static void DFS(int x, int y){
        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<N && board[nx][ny]==1){
                board[nx][ny]=0;
                DFS(nx,ny);
            }
        }
    }

    public static void solution(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j]==1){
                    answer++;
                    board[i][j]=0;
                    DFS(i,j);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(answer);

    }
}
