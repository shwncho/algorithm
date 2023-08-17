import java.io.*;
import java.util.*;

public class Main{
    static int[][] memo = new int[31][31];
    public static int combi(int n, int r){
        if(memo[n][r]>0)    return memo[n][r];
        else if(n==r || r==0)   return 1;
        else return memo[n][r] = combi(n-1,r-1) + combi(n-1,r);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            sb.append(combi(n,r)).append("\n");

        }

        System.out.println(sb);
    }
}