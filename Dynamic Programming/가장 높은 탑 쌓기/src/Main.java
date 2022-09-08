import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    static int[] dp;
    static int[][] arr;
    public static int solution(int n){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            dp[i]=arr[i][1];
            int tmp=0;

            for(int j=i-1; j>=0; j--){
                if(arr[i][2]<arr[j][2] && tmp<dp[j]){
                    tmp=dp[j];
                }
            }
            dp[i]=dp[i]+tmp;
            max=Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());
        dp=new int[n];
        arr=new int[n][3];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //width,height,weight 순으로 받고 width 정렬
        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0]).reversed());
        System.out.println(solution(n));

    }
}
