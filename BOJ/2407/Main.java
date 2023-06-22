import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;


        // n C r = n! / (n-r)! * r! 이용
        for(int i=0; i<m; i++){
            n1 = n1.multiply(BigInteger.valueOf(n-i));
            n2 = n2.multiply(BigInteger.valueOf(i+1));
        }

        System.out.println(n1.divide(n2));

    }
}
