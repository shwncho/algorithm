import java.io.*;
import java.util.*;

public class Main{
    static int h,w;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void DFS(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<h && ny>=0 && ny<w && !visited[nx][ny] && graph[nx][ny]=='#'){
                visited[nx][ny]=true;
                graph[nx][ny]='.';
                DFS(nx,ny);
            }
        }
    }
    public static int solution(){
        int cnt = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(graph[i][j]=='#'){
                    visited[i][j]=true;
                    DFS(i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){

            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph = new char[h][w];
            visited = new boolean[h][w];
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                graph[i] = st.nextToken().toCharArray();
            }

            sb.append(solution()).append("\n");
        }

        System.out.println(sb);

    }
}