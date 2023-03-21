import java.io.*;
import java.util.*;

class Main{
    static long[] memo=new long[91];
    static long fibo(int n){
        if(n<3) return memo[n];

        if(memo[n]>0)   return memo[n];

        return memo[n]=fibo(n-1)+fibo(n-2);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo[1]=memo[2]=1;

        System.out.println(fibo(n));
    }
}