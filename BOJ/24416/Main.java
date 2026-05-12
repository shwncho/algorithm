import java.io.*;
import java.util.*;
public class Main {
    static int r1 = 0;
    static int r2 = 0;
    private static int fib(int n) {
        if(n==1 || n==2){
            r1++;
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 1;
        for(int i=3; i<=n; i++) {
            r2++;
            arr[i] = arr[i-1] + arr[i-2];
        }

        fib(n);
        System.out.println(r1 + " " + r2);
    }
}
