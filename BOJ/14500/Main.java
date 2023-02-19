import java.util.*;
import java.io.*;

public class Main{
    static int n,m,answer=0;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void DFS(int x, int y,int sum, int cnt){
        if(cnt==4){
            answer=Math.max(answer,sum);
        }
        else{

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    DFS(nx,ny,sum+graph[nx][ny],cnt+1);
                    visited[nx][ny]=false;
                }
            }
        }
    }
    public static void other(int x, int y){
        int square = 4;
        int min = Integer.MAX_VALUE;
        int result = graph[x][y];
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(square<=2)    return;

            if(nx<0 || nx>=n || ny<0 || ny>=m){
                square--;
                continue;
            }

            min = Math.min(min,graph[nx][ny]);
            result+=graph[nx][ny];
        }

        if(square==4){
            result-=min;
        }

        answer = Math.max(answer,result);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph=new int[n][m];
        visited=new boolean[n][m];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j]=true;
                DFS(i,j,graph[i][j],1);
                visited[i][j]=false;
                other(i,j);
            }
        }

        System.out.println(answer);
    }
}