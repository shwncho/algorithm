import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int rank = 1;
    static int[] order;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        order = new int[N+1];
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1; i<=N; i++) Collections.sort(graph.get(i), Collections.reverseOrder());

        order[R] = rank++;
        DFS(R);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb);

    }
    private static void DFS(int s){
        visited[s] = true;
        for(int next : graph.get(s)){
            if(!visited[next]){
                order[next] = rank++;
                DFS(next);
            }
        }
    }
}
