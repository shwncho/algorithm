import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] bag={3,5};
    static int[] dp;
    static int weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        weight = Integer.parseInt(br.readLine());

        dp=new int[weight+1];

        Arrays.fill(dp,5001);
        dp[0]=0;
        for(int x : bag){
            for(int j=x; j<=weight; j++){
                dp[j]=Math.min(dp[j],dp[j-x]+1);
            }
        }
        System.out.println(dp[weight]!=5001 ? dp[weight] : -1);

    }
}
