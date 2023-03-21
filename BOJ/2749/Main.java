import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int mod = 1000000;
        //주기 p, 15*10^(k-1)
        int p = mod/10 * 15;
        int[] fibo = new int[p];
        fibo[1]=1;

        for(int i=2; i<p; i++){
            fibo[i]=(fibo[i-1]+fibo[i-2])%mod;
        }
        System.out.println(fibo[(int)(n%p)]);


    }
}