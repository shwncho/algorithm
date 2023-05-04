import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][3];
        int[][] arr = new int[n+1][3];

        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int[] answer = new int[3];

        // i=> 첫번째 집 색
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==j){
                    dp[1][j]=arr[1][j];
                }
                //첫번째 집의 색이 위에서 i로 정해졌기 때문에 다른 부분은 뭐가 들어가던 상관 없다.
                //대신에 집을 칠하는 비용이 1000이 최대 이기 때문에 최솟값으로 인식 못하게 1001을 입력
                else{
                    dp[1][j]=1001;
                }
            }

            for(int k=2; k<=n; k++){
                dp[k][0] = Math.min(dp[k-1][1],dp[k-1][2]) + arr[k][0];
                dp[k][1] = Math.min(dp[k-1][0],dp[k-1][2]) + arr[k][1];
                dp[k][2] = Math.min(dp[k-1][0],dp[k-1][1]) + arr[k][2];

                //마지막 집
                if(k==n){
                    if(i==0){
                        answer[i]=Math.min(dp[n][1],dp[n][2]);
                    }
                    else if(i==1){
                        answer[i]=Math.min(dp[n][0],dp[n][2]);
                    }
                    else if(i==2){
                        answer[i]=Math.min(dp[n][0],dp[n][1]);
                    }
                }
            }



        }



        System.out.println(Math.min(answer[0],Math.min(answer[1],answer[2])));

    }
}
