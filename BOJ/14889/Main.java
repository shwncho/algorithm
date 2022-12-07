import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] graph;
    static boolean[] visited;

    static int answer=Integer.MAX_VALUE;
    static void DFS(int x, int L){
        if(L==n/2){
            difference();
            return;
        }
        for(int i=x; i<n; i++){
            if(!visited[i]){
                visited[i]=true;
                DFS(i+1,L+1);
                visited[i]=false;
            }
        }
    }

    static void difference(){
        int teamStart=0;
        int teamLink=0;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(visited[i] && visited[j]){
                    teamStart+=graph[i][j]+graph[j][i];
                }
                else if(!visited[i] && !visited[j]){
                    teamLink+=graph[i][j]+graph[j][i];
                }
            }
        }

        int tmp = Math.abs(teamStart-teamLink);

        if(tmp==0){
            System.out.println(0);
            System.exit(0);
        }

        answer = Math.min(answer,tmp);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph=new int[n][n];
        visited=new boolean[n];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        DFS(0,0);
        System.out.println(answer);



    }
}
