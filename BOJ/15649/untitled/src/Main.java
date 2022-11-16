import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] ch,pm;
    public static void DFS(int L, int[] arr){
        if(L==m){
            for (int x : pm) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
        else{
            for(int i=0; i<n; i++){
                if(ch[i]==0){
                    ch[i]=1;
                    pm[L]=arr[i];
                    DFS(L+1,arr);
                    ch[i]=0;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=1; i<=n; i++) arr[i-1]=i;
        ch=new int[n];
        pm=new int[m];
        DFS(0,arr);
    }
}
