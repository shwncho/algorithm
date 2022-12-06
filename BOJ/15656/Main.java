import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] arr,pm;
    static StringBuilder sb = new StringBuilder();
    static void DFS(int L){
        if(L==m){
            for(int x : pm) sb.append(String.valueOf(x)).append(" ");
            sb.append("\n");
        }
        else{
            for(int i=0; i<n; i++){
                pm[L]=arr[i];
                DFS(L+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        pm=new int[m];
        arr=new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        DFS(0);
        System.out.println(sb);

    }
}
