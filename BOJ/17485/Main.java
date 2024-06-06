import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][][] dp = new int [N+1][M][3];
        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;
                if(j==0){
                    dp[i][j][2]=Integer.MAX_VALUE;
                }
                if(j==M-1){
                    dp[i][j][0]=Integer.MAX_VALUE;
                }
            }
        }

        dp[N][0][2] = Integer.MAX_VALUE;
        dp[N][M-1][0] = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++){
            for(int j=0; j<M; j++){
                //왼쪽 대각선 아래로 이동하는 경우
                if(isValid(i-1,j+1)){
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + arr[i-1][j];
                }
                //아래로 이동하는 경우
                if(isValid(i-1,j)){
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i-1][j];
                }

                //오른쪽 대각선 아래로 이동하는 경우
                if(isValid(i-1,j-1)){
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + arr[i-1][j];
                }

            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<M; i++){
            for(int j=0; j<3; j++){
                answer = Math.min(answer, dp[N][i][j]);
            }
        }

        System.out.println(answer);
    }

    private static boolean isValid(int x, int y){
        return 0<=x && x<N && 0<=y && y<M;
    }
}
