import java.io.*;
import java.util.*;
public class Main {
    static int[][] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        cache = new int[N+1][K+1];

        System.out.println(binoCoef(N,K));


    }

    private static int binoCoef(int n, int k) {
        if(n==k || k==0)    return 1;

        if(cache[n][k]!=0) return cache[n][k];

        return cache[n][k] = binoCoef(n-1,k) + binoCoef(n-1,k-1);
    }
}
