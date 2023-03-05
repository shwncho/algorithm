import java.util.*;
import java.io.*;

public class Main{
    static int n,k;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //노드의 개수
        n = Integer.parseInt(st.nextToken());
        // 간선의 개수
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        indegree=new int[n+1];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }
        topologySort();


    }
    public static void topologySort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++){
            if(indegree[i]==0)  q.offer(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);

            //해당 노드와 연결된 노드들의 진입차수에서 1빼기
            for(int i=0; i<graph.get(now).size(); i++){
                indegree[graph.get(now).get(i)]--;
                if(indegree[graph.get(now).get(i)]==0){
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        for (int x : result){
            System.out.print(x+" ");
        }
    }
}