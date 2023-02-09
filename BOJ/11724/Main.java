import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int answer=0;
    static boolean[] visited;
    static void BFS(int x){
        Queue<Integer> q = new LinkedList<>();

        if(visited[x])  return;
        else{
            q.add(x);
            visited[x]=true;

            while(!q.isEmpty()){
                int tmp = q.poll();
                int size = graph.get(tmp).size();

                for(int i=0; i<size; i++){
                    int value = graph.get(tmp).get(i);
                    //방문한 곳이 아니면
                    if(!visited[value]){
                        visited[value]=true;
                        q.add(value);
                    }
                }
            }
            answer++;

        }
    }
    static void DFS(int x){
        if(visited[x])  return;
        else{
            visited[x]=true;
            int size = graph.get(x).size();
            for(int i=0; i<size; i++){
                int value = graph.get(x).get(i);
                if(!visited[value]){
                    DFS(value);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        visited = new boolean[n+1];

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //방향 없는 그래프
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

//        for(int i=1; i<=n; i++){
//            if(!visited[i]){
//                BFS(i);
//            }
//        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                DFS(i);
                answer++;
            }
        }

        System.out.println(answer);



    }
}
