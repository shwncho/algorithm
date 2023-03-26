import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree=new int[n+1];

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }

        topologySort();
    }

    public static void topologySort(){
        Queue<Integer> q = new LinkedList<>();
        int[] arr = new int[n+1];
        int cnt=1;

        for(int i=1; i<=n; i++){
            if(indegree[i]==0)  q.offer(i);
        }

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0; i<len; i++){
                int now = q.poll();

                arr[now]=cnt;

                for(int x : graph.get(now)){
                    indegree[x]--;

                    if(indegree[x]==0)  q.offer(x);
                }
            }
            cnt++;
        }

        for(int i=1; i<=n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
