import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] grid = new int[N][3];
        int[][] maxDP = new int[N+1][3];
        int[][] minDP = new int[N+1][3];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                minDP[i+1][j] = grid[i][j];
            }
        }


        for(int i = 1; i <= N; i++){
            maxDP[i][0] = Math.max(maxDP[i-1][0],maxDP[i-1][1]) + grid[i-1][0];
            maxDP[i][1] = Math.max(maxDP[i-1][0], Math.max(maxDP[i-1][1],maxDP[i-1][2])) + grid[i-1][1];
            maxDP[i][2] = Math.max(maxDP[i-1][1], maxDP[i-1][2]) + grid[i-1][2];

            minDP[i][0] = Math.min(minDP[i-1][0],minDP[i-1][1]) + grid[i-1][0];
            minDP[i][1] = Math.min(minDP[i-1][0], Math.min(minDP[i-1][1],minDP[i-1][2])) + grid[i-1][1];
            minDP[i][2] = Math.min(minDP[i-1][1], minDP[i-1][2]) + grid[i-1][2];
        }

        int max = Math.max(maxDP[N][0],Math.max(maxDP[N][1],maxDP[N][2]));
        int min = Math.min(minDP[N][0],Math.min(minDP[N][1],minDP[N][2]));

        System.out.println(max+" "+min);

    }
}
