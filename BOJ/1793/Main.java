import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String n = br.readLine();
            if(n==null || n.equals(""))    break;
            int num = Integer.parseInt(n);

            sb.append(solution(num)).append("\n");
        }

        System.out.println(sb);
    }

    private static BigInteger solution(int num){
        if(num==0)  return new BigInteger("1");
        if(num==1)  return new BigInteger("1");
        if(num==2)  return new BigInteger("3");

        BigInteger[] dp = new BigInteger[num+1];

        dp[1]=new BigInteger("1");
        dp[2]=new BigInteger("3");

        for(int i=3; i<=num; i++){
            dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
        }

        return dp[num];
    }
}
