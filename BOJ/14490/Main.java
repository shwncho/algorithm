import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(":");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int k = gcd(n, m);
        StringBuilder sb = new StringBuilder();
        sb.append(n/k).append(":").append(m/k);

        System.out.println(sb);

    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
