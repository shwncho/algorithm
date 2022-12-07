import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long gcd(long a, long b){
        long r1=a; long r2=b;
        long s1=1; long s2=0;
        long t1=0; long t2=1;

        while(r2>0){
            long q = r1/r2;
            long r = r1-q*r2;
            r1=r2;
            r2=r;

            long s = s1-q*s2;
            s1=s2;
            s2=s;

            long t = t1-q*t2;
            t1=t2;
            t2=t;
        }

        return r1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(a*b/gcd(a,b));


    }
}
