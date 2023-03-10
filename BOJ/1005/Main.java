import java.util.*;
import java.io.*;

public class Main{
    static int n,k;
    static int[] indegree,arr,time;

    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<ArrayList<Integer>> reverseGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            st=new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            reverseGraph = new ArrayList<>();
            for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
            for(int i=0; i<=n; i++) reverseGraph.add(new ArrayList<>());

            indegree=new int[n+1];
            time=new int[n+1];
            arr=new int[n+1];

            st = new StringTokenizer(br.readLine());

            for(int i=1; i<=n; i++) time[i]=Integer.parseInt(st.nextToken());

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                reverseGraph.get(b).add(a);
                indegree[b]++;
            }
            int target = Integer.parseInt(br.readLine());
            topologySort();

            sb.append(arr[target]).append("\n");
        }

        System.out.println(sb);

    }
    public static void topologySort(){
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++){
            if(indegree[i]==0)  q.offer(i);
        }

        while(!q.isEmpty()){
            int len = q.size();
            for(int j=0; j<len; j++){
                int now = q.poll();
                arr[now]=time[now];
                int max = 0;
                for(int i=0; i<reverseGraph.get(now).size(); i++){
                    max=Math.max(max,arr[reverseGraph.get(now).get(i)]);
                }
                arr[now]+=max;
                //해당 노드와 연결된 노드들의 진입차수에서 1빼기
                for(int i=0; i<graph.get(now).size(); i++){
                    indegree[graph.get(now).get(i)]--;
                    if(indegree[graph.get(now).get(i)]==0){
                        q.offer(graph.get(now).get(i));
                    }
                }
            }


        }
    }
}