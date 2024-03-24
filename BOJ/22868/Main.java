import java.io.*;
import java.util.*;
public class Main{

    static class Node{
        int vex, cnt;
        Node(int vex, int cnt){
            this.vex =vex;
            this.cnt =cnt;
        }
    }
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] route;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        visited = new boolean[N+1];
        route = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1; i<=N; i++) Collections.sort(graph.get(i));

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int answer = BFS(S,E);

        visited = new boolean[N+1];

        int prev = route[E];
        while(prev!=S){
            visited[prev]=true;
            prev = route[prev];
        }

        visited[S]=false;
        answer+=BFS(E,S);
        System.out.println(answer);

    }

    private static int BFS(int start ,int end){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(new Node(start, 0));
        visited[start]=true;

        while(!Q.isEmpty()){

            Node now = Q.poll();

            for(int next : graph.get(now.vex)){
                if(visited[next]) continue;

                visited[next] = true;

                route[next]=now.vex;

                Q.offer(new Node(next,now.cnt+1));

                if(next==end){
                    return now.cnt+1;
                }

            }
        }



        return 0;
    }
}