import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static char[][] graph;
    static boolean[] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    //아무곳도 못갈경우 그 자리 이동 수 => 1
    static int answer=1;
    static void DFS(int x, int y,int cnt){
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            //최대값의 경로가 아닐 수 있음
            if(nx>=0 && nx<n && ny>=0 && ny<m && (!visited[graph[nx][ny]-'A'] )){
                cnt++;
                visited[graph[nx][ny]-'A']=true;
                answer=Math.max(answer,cnt);
                DFS(nx,ny,cnt);
                cnt--;
                visited[graph[nx][ny]-'A']=false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        visited = new boolean[26];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j]=s.charAt(j);
            }
        }

        visited[graph[0][0]-'A']=true;
        DFS(0,0,1);

        System.out.println(answer);

    }
}
