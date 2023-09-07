import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int BFS(int s, int e){
        Queue<Integer> Q = new LinkedList<>();
        int[] ch = new int[n+1];
        Q.offer(s);
        int L = 0;
        ch[s]=1;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int v = Q.poll();

                for(Integer x : graph.get(v)){

                    if( x == e) return L+1;

                    if(ch[x] == 1)  continue;

                    ch[x] = 1;
                    Q.offer(x);
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] answer = new int[n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j)    continue;
                answer[i]+=BFS(i,j);
            }
        }

        int result = 0;
        int min = Integer.MAX_VALUE;

        for(int i=1; i<=n; i++){
            if(answer[i] < min){
                result = i;
                min = answer[i];
            }
        }

        System.out.println(result);

    }
}
