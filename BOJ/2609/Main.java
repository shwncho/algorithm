import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대공약수, 최소공배수 --> 유클리드 호제법 이용
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = a>b ? GCD(a,b) : GCD(b,a);

        System.out.println(gcd);
        System.out.println(a*b/gcd);


    }

    public static int GCD(int a, int b){
        if(a%b==0){
            return b;
        }
        return GCD(b, a%b);


    }

}
