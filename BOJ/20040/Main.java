import java.util.*;
import java.io.*;

public class Main{
    static int[] unf;
    static int Find(int v){
        if(v==unf[v])   return v;
        else return unf[v]=Find(unf[v]);
    }
    static void Union(int a, int b){
        int fa = unf[a];
        int fb = unf[b];

        if(fa!=fb)  unf[fa]=fb;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        unf=new int[n];
        for(int i=0; i<n; i++)  unf[i]=i;

        int cnt=0;
        for(int i=0; i<k; i++){
            st=new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int fa = Find(a);
            int fb = Find(b);

            if(fa!=fb){
                Union(a,b);
            }
            else{
                System.out.println(cnt+1);
                System.exit(0);
            }

            cnt++;
        }
        System.out.println(0);
    }
}