import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,depth;
    static int[][] graph;
    static int answer=Integer.MAX_VALUE;
    static int[] ch;
    public static void DFS(int L){
        if(L==depth){
            int link=0;
            int start=0;
            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    if(ch[i]==1 && ch[j]==1){
                        link+=graph[i][j] + graph[j][i];
                    }
                    else if(ch[i]==0 && ch[j]==0){
                        start+=graph[i][j] + graph[j][i];
                    }
                }
            }
            answer = Math.min(answer,Math.abs(link-start));
        }
        else{
            ch[L]=1;
            DFS(L+1);
            ch[L]=0;
            DFS(L+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        graph=new int[n][n];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());

            }
        }

        for(int i=1; i<=n; i++){
            //팀을 나누는 인원 수 기준
            depth=i;
            ch=new int[n];
            DFS(0);
        }
        System.out.println(answer);

    }
}
