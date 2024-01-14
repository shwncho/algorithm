import java.io.*;
import java.util.*;
public class Main{
    static int n;
    static int[][] map;
    static boolean[][] colors;
    static boolean[][] visited;
    static int blackCnt=0;
    static int whiteCnt=0;
    static int[] dx = {-1,-1};
    static int[] dy = {-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        colors = new boolean[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                colors[i][j] = (i%2==0 && j%2==0) || (i%2!=0 && j%2!=0);
            }
        }

        //black
        solution(0,true,0);
        solution(0,false,0);

        System.out.println(blackCnt + whiteCnt);

    }

    public static void solution(int idx, boolean black, int cnt){

        for(int i=idx; i<n*n; i++){
            int x = i/n;
            int y = i%n;

            if(colors[x][y]!=black || map[x][y]==0 || !check(x,y))  continue;

            visited[x][y]=true;
            solution(i+1,black,cnt+1);
            visited[x][y]=false;
        }

        if(black)   blackCnt = Math.max(blackCnt, cnt);
        else whiteCnt = Math.max(whiteCnt, cnt);
    }

    public static boolean check(int x, int y){
        // 0,0 부터 시작하므로 아래 부분에는 비숍이 없음
        // 위 쪽 대각선만 체크
        for(int i=0; i<2; i++){
            int nx = x;
            int ny = y;
            while(true){
                if(nx<0 || nx>=n || ny<0 || ny>=n)  break;
                if(visited[nx][ny]) return false;
                nx+=dx[i];
                ny+=dy[i];
            }
        }
        return true;
    }
}