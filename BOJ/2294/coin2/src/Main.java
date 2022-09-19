import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n,k;
    static int[] dp,coin;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();

        dp=new int[k+1];
        coin=new int[n];

        for(int i=0; i<n; i++){
            coin[i]=sc.nextInt();
        }

        Arrays.fill(dp,10001);
        dp[0]=0;

        for(int i=0; i<n; i++){
            for(int j=coin[i]; j<=k; j++){
                dp[j]=Math.min(dp[j],dp[j-coin[i]]+1);
            }
        }
        System.out.println(dp[k]!=10001 ? dp[k] : -1);



    }
}
