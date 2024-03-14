import java.io.*;
import java.util.*;
public class Main {

    static class Node implements Comparable<Node>{
        public int vex, cnt;
        Node(int vex, int cnt){
            this.vex = vex;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o){
            if(this.cnt == o.cnt)   return this.vex - o.vex;
            return this.cnt - o.cnt;
        }
    }
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited=new boolean[N+1];
        int[] disS = new int[N+1];
        int[] disE = new int[N+1];
        Arrays.fill(disS, Integer.MAX_VALUE);
        Arrays.fill(disE, Integer.MAX_VALUE);

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int answer = 0;
        BFS(S,disS);
        BFS(E,disE);
        answer += disS[E];

        checkRoute(disS, disE, S, E);

        disE = new int[N+1];
        Arrays.fill(disE,Integer.MAX_VALUE);
        BFS(E,disE);
        answer += disE[S];
        System.out.println(answer);

    }

    private static void BFS(int start, int[] dis){
        Queue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(start, 0));
        dis[start]=0;
        while(!pQ.isEmpty()){
            Node now = pQ.poll();

            if(now.cnt>dis[now.vex])    continue;

            for(Node next : graph.get(now.vex)){
                if(visited[next.vex])   continue;
                if(dis[next.vex] > now.cnt + next.cnt){
                    dis[next.vex] = now.cnt + next.cnt;
                    pQ.offer(new Node(next.vex, now.cnt + next.cnt));
                }
            }
        }

    }

    private static void checkRoute(int[] disS, int[] disE, int S, int E){
        int prev = S;
        while(S!=E){
            int min = Integer.MAX_VALUE;
            for(Node next : graph.get(S)){
                //양방향 이므로 이전에 돌았던 노드면 스킵
                if(next.vex == prev)    continue;
                //S까지의 거리 + 다음 노드 까지의 거리 + 도착지에서 다음 노드 까지의 거리 == 최단거리 성립 여부 체크
                //사전순 가장 작은 노드 값을 기록
                if(disS[S] + next.cnt + disE[next.vex] == disS[E]){
                    min = Math.min(min, next.vex);
                }
            }
            prev = S;
            S = min;
            if(S!=E)    visited[S]=true;
        }
    }
}
