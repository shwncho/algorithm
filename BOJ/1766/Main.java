import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        indegree = new int[n+1];

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }

        topologySort();

    }

    public static void topologySort(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            if(indegree[i]==0)  pq.offer(i);
        }

        while(!pq.isEmpty()){
            int len = pq.size();
            for(int i=0; i<len; i++){
                int now = pq.poll();


                for(int j=0; j<graph.get(now).size(); j++){
                    indegree[graph.get(now).get(j)]--;
                    if(indegree[graph.get(now).get(j)]==0){
                        pq.offer(graph.get(now).get(j));
                    }
                }
                System.out.print(now+" ");

            }
        }


    }
}
