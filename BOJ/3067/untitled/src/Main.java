import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] coin;
    static int[] dp;
    static int solution(int n, int cache){
        dp[0]=1;
        for(int i=0; i<n; i++){
            for(int j=coin[i]; j<=cache; j++){
                dp[j]=dp[j]+dp[j-coin[i]];
            }
        }


        return dp[cache];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            coin= new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                coin[j]=Integer.parseInt(st.nextToken());
            }

            int cache=Integer.parseInt(br.readLine());
            dp=new int[cache+1];
            System.out.println(solution(n, cache));
        }

    }
}
