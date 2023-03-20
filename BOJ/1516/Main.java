import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] indegree,arr,time;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        indegree=new int[n+1];
        arr=new int[n+1];
        time=new int[n+1];

        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());

            time[i]=Integer.parseInt(st.nextToken());

            while(true){
                int previous = Integer.parseInt(st.nextToken());
                if(previous==-1)    break;

                indegree[i]++;

                graph.get(previous).add(i);
            }
        }

        topologySort();

    }

    public static void topologySort(){

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++){
            if(indegree[i]==0)  q.offer(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(Integer next : graph.get(now)){
                indegree[next]--;

                //동시에 지어질 경우를 고려해서 선수 빌딩중 오래 걸리는 시간을 기준으로 잡는다.
                //다음 건물을 짓기 전까지 걸린 시간을 저장한 뒤 마지막에 본인 건물 짓는 시간을 더해준다.
                arr[next]=Math.max(arr[next],arr[now]+time[now]);

                if(indegree[next]==0)  q.offer(next);
            }

        }

        for(int i=1; i<=n; i++){
            System.out.println(arr[i]+time[i]);
        }
    }
}
