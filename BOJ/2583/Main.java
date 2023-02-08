import java.util.*;
import java.io.*;

public class Main {
    static int m,n;
    static int[][] graph;
    static int count;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Integer> list = new ArrayList<>();
    static void DFS(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && graph[nx][ny]==0){
                graph[nx][ny]=1;
                count++;
                DFS(nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());



        graph = new int[n][m];

        for(int i=0; i<k; i++){
            st=new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int a=x1; a<x2; a++){
                for(int b=y1; b<y2; b++){
                    graph[a][b]=1;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j]==0){
                    count=1;
                    graph[i][j]=1;
                    DFS(i,j);
                    list.add(count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        Collections.sort(list);

        for(int x : list){
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
