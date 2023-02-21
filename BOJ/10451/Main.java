import java.util.*;
import java.io.*;

public class Main{
    static int[] graph;
    static boolean[] visited;
    static int answer;
    public static void BFS(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v]=true;

        while(!q.isEmpty()){
            int nv = graph[q.poll()];

            if(!visited[nv]){
                visited[nv]=true;
                q.offer(nv);
            }
        }
        answer++;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int k=0; k<t; k++){
            int n = Integer.parseInt(br.readLine());

            graph=new int[n+1];
            visited = new boolean[n+1];
            answer=0;

            st=new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                graph[i]=Integer.parseInt(st.nextToken());
            }


            for(int i=1; i<=n; i++){
                if(!visited[i]){
                    BFS(i);
                }
            }


            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}