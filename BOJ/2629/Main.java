import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] weight;
    static int N;
    static boolean[][] dp = new boolean[31][15001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        weight = new int[31];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  weight[i] = Integer.parseInt(st.nextToken());

        solution(0,0);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());

            if(num>15000)   sb.append("N").append(" ");
            else if(dp[N][num]) sb.append("Y").append(" ");
            else sb.append("N").append(" ");
        }

        System.out.println(sb);
    }

    public static void solution(int i, int w){
        if(i>N || dp[i][w]) return;
        dp[i][w]=true;
        solution(i+1, w);
        solution(i+1, w+weight[i]);
        solution(i+1,Math.abs(w-weight[i]));
    }
}
