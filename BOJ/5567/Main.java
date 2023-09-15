import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] result;
    public static void BFS(){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        while(!Q.isEmpty()){
            int value = Q.poll();

            for(int tmp : graph.get(value)){
                if(result[tmp]==0){
                    result[tmp]=result[value]+1;
                    Q.offer(tmp);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        result=new int[n+1];
        for(int i=0; i<n+1; i++)  graph.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        BFS();
        int cnt = 0;

        for(int i=2; i<=n; i++){
            if(0 < result[i] && result[i] <=2)  cnt++;
        }
        System.out.println(cnt);


    }
}
