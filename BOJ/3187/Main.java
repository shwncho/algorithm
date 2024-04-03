import java.io.*;
import java.util.*;
public class Main {
    static int r,c;
    static char[][] map;
    static int kSum,vSum;
    static int kResult=0, vResult=0;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{

        // 이차원 배열 탐색하면서 k or v 발견
        // 방문처리 해주면서 k와 v 마리 수 세기
        // k>v 이면 양 마리 수 결과에 합산, k<=v 이면 늑대 마리 수 결과에 합산

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = s.charAt(j);
            }
        }

        solution();

        System.out.println(kResult + " " + vResult);

    }

    private static void solution(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(!visited[i][j] && map[i][j]!='#'){
                    kSum = 0; vSum = 0;
                    DFS(i,j);

                    if(kSum > vSum) kResult+=kSum;
                    else vResult += vSum;
                }
            }
        }
    }

    private static void DFS(int x, int y){
        if(map[x][y]=='k')  kSum++;

        if(map[x][y]=='v')  vSum++;

        visited[x][y]=true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=r || ny<0 || ny>=c)  continue;

            if(map[nx][ny]=='#' || visited[nx][ny]) continue;

            DFS(nx,ny);
        }
    }
}
