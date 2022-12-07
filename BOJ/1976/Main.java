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
        StringTokenizer st;

        int n =Integer.parseInt(br.readLine());
        int m =Integer.parseInt(br.readLine());

        unf=new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;

        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                if(Integer.parseInt(st.nextToken())==1) Union(i,j);
            }
        }
        Integer answer;
        boolean flag=true;
        st=new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        answer=Find(a);
        for(int i=0; i<m-1; i++){
            int b = Integer.parseInt(st.nextToken());
            if(answer.compareTo(Find(b))!=0) flag=false;
        }

        System.out.println(flag ? "YES" : "NO");

    }
}
