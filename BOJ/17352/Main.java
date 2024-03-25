import java.util.*;
import java.io.*;
public class Main {
    static int[] unf;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        unf = new int[N+1];
        for(int i=1; i<=N; i++) unf[i] = i;

        for(int i=0; i<N-2; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Union(a,b);
        }

        for(int i=1; i<N; i++){
            int fa = Find(i);
            int fb = Find(i+1);

            if(fa!=fb){
                System.out.println(String.valueOf(i)+" "+String.valueOf(i+1));
                break;
            }
        }

    }

    private static int Find(int v){
        if(v==unf[v])   return v;
        else return unf[v] = Find(unf[v]);
    }

    private static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb)  unf[fa]=fb;
    }
}
