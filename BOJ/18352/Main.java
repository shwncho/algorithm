import java.io.*;
import java.util.*;
public class Main {
    static int[] dis;
    static boolean[] visited;
    static List<List<Integer>> cities = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        dis = new int[N+1];
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++) cities.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cities.get(a).add(b);
        }

        BFS(X,K);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=1; i<=N; i++){
            if(i==X)    continue;
            if(dis[i]==K){
                sb.append(i).append("\n");
                cnt++;
            }
        }

        System.out.println(cnt==0 ? -1 : sb);
    }

    private static void BFS(int X,int K){
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        visited[X]=true;
        while(!q.isEmpty()){
            int now = q.poll();
            if(dis[now]>K)  continue;
            for(int next : cities.get(now)){
                if(!visited[next]){
                    visited[next]=true;
                    dis[next]=dis[now]+1;
                    q.offer(next);
                }
            }
        }
    }
}
