import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        final int INF = 10_000_000;

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] dis = new int[N+1][N+1];
            for(int i=1; i<=N; i++){
                Arrays.fill(dis[i],INF);
            }

            for(int i=1; i<=N; i++){
                dis[i][i]=0;
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                dis[a][b]=c;
                dis[b][a]=c;
            }

            for(int k=1; k<=N; k++){
                for(int i=1; i<=N; i++){
                    for(int j=1; j<=N; j++){
                        if(dis[i][j] > dis[i][k] + dis[k][j])
                            dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }

            int K = Integer.parseInt(br.readLine());
            int[][] arr = new int[K][N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++){
                int n = Integer.parseInt(st.nextToken());

                for(int j=1; j<=N; j++){
                    arr[i][j] = dis[n][j];
                }
            }

            Queue<Integer> pQ = new PriorityQueue<>();
            int[] sum = new int[N+1];
            for(int[] a : arr){
                for(int i=1; i<=N; i++){
                    sum[i] += a[i];
                }
            }

            int min = Integer.MAX_VALUE;
            for(int i=1; i<=N; i++){
                min = Math.min(min, sum[i]);
            }

            for(int i=1; i<=N; i++){
                if(sum[i]==min) pQ.offer(i);
            }

            sb.append(pQ.poll()).append("\n");


        }
        System.out.println(sb);
    }
}
