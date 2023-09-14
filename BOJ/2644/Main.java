import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int BFS(int s, int e){
        int[] ch = new int[101];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int L = 0;
        ch[s]=1;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int v = Q.poll();
                for(Integer num : graph.get(v)){

                    if(num == e) return L+1;

                    if(ch[num] == 1)    continue;

                    ch[num]=1;
                    Q.offer(num);
                }
            }
            L++;
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(b).add(a);
            graph.get(a).add(b);
        }

        System.out.println(BFS(start, end));
    }
}
