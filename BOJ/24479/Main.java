import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int order = 1;
    static Map<Integer,Integer> result = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1; i<=N; i++) Collections.sort(graph.get(i));

        DFS(R);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(!result.containsKey(i))  sb.append(0).append("\n");
            else sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    private static  void DFS(int x){
        result.put(x,order++);
        for(int next : graph.get(x)){
            if(!result.containsKey(next)){
                DFS(next);
            }
        }
    }
}
