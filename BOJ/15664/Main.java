import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] combi,arr;
    static StringBuilder sb = new StringBuilder();
    static void DFS(int L, int s){
        if(L==m){
            for(int x : combi)  sb.append(String.valueOf(x)).append(" ");
            sb.append("\n");
        }
        else{
            int[] checked=new int[10001];
            for(int i=s; i<n; i++){
                if(checked[arr[i]]==0){
                    checked[arr[i]]=1;
                    combi[L]=arr[i];
                    DFS(L+1,i+1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        combi=new int[m];
        arr=new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        DFS(0,0);
        System.out.println(sb);
    }
}
