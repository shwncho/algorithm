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

        indegree = new int[n+1];

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());


            for(int j=0; j<num-1; j++){
                int after = Integer.parseInt(st.nextToken());
                graph.get(before).add(after);
                indegree[after]++;

                before=after;
            }

        }

        topologySort();

    }

    public static void topologySort(){
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=1; i<=n; i++){
            if(indegree[i]==0)  q.offer(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int x : graph.get(now)){
                indegree[x]--;

                if(indegree[x]==0)  q.offer(x);
            }

            result.add(now);
        }

        if(result.size()!=n) System.out.println(0);
        else{
            for(int x : result){
                System.out.println(x);
            }
        }

    }
}
