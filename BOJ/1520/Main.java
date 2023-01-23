import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int[][] dp,graph;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static int DFS(int x, int y){
        if(x==n-1 && y==m-1){
            return 1;
        }

        if(dp[x][y]!=-1){
            // 이미 방문했을 경우 그 지점의 누적된 값 return
            return dp[x][y];
        }

        // 0으로 방문 표시
        dp[x][y]=0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && graph[nx][ny] < graph[x][y]){
                dp[x][y]+=DFS(nx,ny);
            }
        }

        return dp[x][y];

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        dp = new int[n][m];
        graph = new int[n][m];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                // 초기 -1로 방문하지 않은 곳임을 표시
                dp[i][j]=-1;
            }
        }
        System.out.println(DFS(0,0));
    }
}
