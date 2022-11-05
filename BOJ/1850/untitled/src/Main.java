import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long gcd(long a, long b){
        return b==0 ? a : gcd(b,a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long g=gcd(Math.max(a,b),Math.min(a,b));
        StringBuilder sb = new StringBuilder();
        for(long i=0; i<g; i++) sb.append("1");
        System.out.println(sb.toString());




    }
}
