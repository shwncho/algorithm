import java.io.*;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());

        if(n.compareTo(new BigInteger("1"))==0) System.out.println(1);
        else if(n.compareTo(new BigInteger("2"))==0) System.out.println(2);
        else System.out.println(n.add(n).subtract(new BigInteger("2")));
    }
}