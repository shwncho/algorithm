import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] coin,dp;
    static int change;
    public static int solution(int n){
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0; i<n; i++){
            for(int j=coin[i]; j<=change; j++){
                dp[j]=Math.min(dp[j],dp[j-coin[i]]+1);
            }
        }
        return dp[change];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());

        coin = new int[n];

        for(int i=0; i<n; i++){
            coin[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        change=Integer.parseInt(st.nextToken());
        dp=new int[change+1];

        System.out.println(solution(n));
    }
}
