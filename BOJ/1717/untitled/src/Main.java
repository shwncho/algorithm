import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] unf;
    static int Find(int v){
        if(v==unf[v])   return v;
        else return unf[v]=Find(unf[v]);
    }
    static void Union(int v1, int v2){
        int fa1 = Find(v1);
        int fa2 = Find(v2);
        if(fa1!=fa2)    unf[fa1]=fa2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unf=new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());

            if(a==0)    Union(b,c);
            else{
                if(Find(b)==Find(c)) System.out.println("YES");
                else System.out.println("NO");
            }

        }



    }
}
