import java.io.*;
import java.util.*;
public class Main {
    static int[] unf;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        unf = new int[N+1];
        int cnt = 0;

        for(int i=1; i<=N; i++) unf[i] = i;

        for(int i=0; i<M; i++){
            st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(Find(a)!=Find(b))    Union(a,b);
            //사이클을 끊어야 하는 횟수
            else cnt++;
        }

        //연결해야하는 수
        int link = 0;
        for(int i=1; i<N; i++){
            if(Find(i)!=Find(i+1)){
                link++;
                Union(i,i+1);
            }
        }

        System.out.println(link + cnt);

    }

    static int Find(int v){
        if(v==unf[v])   return v;
        return unf[v] = Find(unf[v]);
    }

    static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb)  unf[fa]=fb;
    }
}
