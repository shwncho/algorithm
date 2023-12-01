import java.io.*;
import java.util.*;
public class Main {
    static long[][] arr;
    static long answer = Integer.MAX_VALUE;
    static long[][] combi;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]= Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            combi = new long[i][2];
            DFS(0,i,0);
        }

        System.out.println(answer);

    }

    public static void DFS(int L, int n, int s){
        if(L==n){
            long sSum=1;
            long bSum=0;
            for(int i=0; i<n; i++){
                sSum*=combi[i][0];
                bSum+=combi[i][1];
            }

            answer=Long.min(answer, Math.abs(sSum-bSum));
        }
        else{
            for(int i=s; i<N; i++){
                combi[L][0]=arr[i][0];
                combi[L][1]=arr[i][1];
                DFS(L+1,n,i+1);
            }
        }
    }
}
