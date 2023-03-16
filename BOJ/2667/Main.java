import java.util.*;
import java.io.*;
public class Main {
    static int n,number=0;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int[] answer;
    static int[][] graph;
    public static void DFS(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx <n && ny>=0 && ny<n && graph[nx][ny]==1){
                graph[nx][ny]=0;
                answer[number]++;
                DFS(nx,ny);

            }
        }
    }
    public static void solution(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]==1){
                    number++;
                    graph[i][j]=0;
                    answer[number]=1;
                    DFS(i,j);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());

        graph=new int[n][n];
        answer = new int[626];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                graph[i][j]=s.charAt(j) - '0';
            }
        }

        solution();

        System.out.println(number);

        Arrays.sort(answer);

        for(int x : answer){
            if(x!=0) System.out.println(x);
        }


    }
}
