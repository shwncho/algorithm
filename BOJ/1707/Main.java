import java.util.*;
import java.io.*;

public class Main{
    static int[] colors;
    //이분 그래프를 쉽게 구별하기 위해 빨강, 파랑으로 색칠
    static int RED = 1;
    static int BLUE = -1;
    static boolean check;
    static ArrayList<ArrayList<Integer>> graph;
    public static void BFS(int v, int color){
        colors[v]=color;
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);

        while(!q.isEmpty() && check){
            int tmp = q.poll();
            int size = graph.get(tmp).size();

            for(int i=0; i<size; i++){
                int nv = graph.get(tmp).get(i);
                if(colors[nv]==0){
                    //인접한 정점은 다른 색깔로
                    colors[nv]=colors[tmp]*-1;
                    q.offer(nv);
                }
                //인접합 정점이 같은 색깔이면 이분 그래프가 아니므로 종료
                else if(colors[nv] + colors[tmp] !=0){
                    check=false;
                    return;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st=new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            //초기화 위치 중요
            graph = new ArrayList<>();
            colors = new int[v+1];
            check = true;

            for(int j=0; j<=v; j++)    graph.add(new ArrayList<>());
            for(int j=0; j<e; j++){
                st=new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for(int j=1; j<v+1; j++){
                //이분그래프가 아니면 탐색 종료
                if(!check)  break;

                //탐색하지 않은 곳
                if(colors[j]==0){
                    BFS(j,RED);
                }
            }

            sb.append(check ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}