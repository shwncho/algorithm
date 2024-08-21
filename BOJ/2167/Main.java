import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] input = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int val = Integer.parseInt(st.nextToken());

                input[i][j] = val;
            }
        }

        int[][] output = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                output[i][j] = input[i-1][j-1] + output[i-1][j] + output[i][j-1] - output[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = output[x2][y2] - output[x2][y1-1] - output[x1-1][y2] + output[x1-1][y1-1];
            sb.append(result).append("\n");
        }

        System.out.println(sb);


    }

}
