import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] graph;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int num;
    static void DFS(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=m)  continue;

            if(graph[nx][ny]==0)    continue;

            graph[nx][ny]=0;
            num++;
            DFS(nx,ny);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;
        int max=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j]==1){
                    cnt++;
                    graph[i][j]=0;
                    num=1;
                    DFS(i,j);
                    max = Math.max(max,num);

                }
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n").append(max);
        System.out.println(sb);



    }
}
