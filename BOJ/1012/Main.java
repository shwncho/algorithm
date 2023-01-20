import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int answer;
    static int[][] graph;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public static void DFS(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && graph[nx][ny]==1){
                graph[nx][ny]=0;
                DFS(nx,ny);
            }
        }
    }


    public static void solution(int x, int y){
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(graph[i][j]==1){
                    answer++;
                    DFS(i,j);
                    graph[i][j]=0;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st=new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());


            answer=0;
            graph=new int[n][m];
            for(int j=0; j<num; j++){
                st=new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[b][a]=1;
            }

            solution(n,m);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
