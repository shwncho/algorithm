import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] ch,pm;
    static StringBuilder sb=new StringBuilder();
    static void DFS(int L, int[] arr){
        if(L==m){
            for (int x : pm) {
                sb.append(x+" ");
            }
            sb.append("\n");
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
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        ch=new int[n];
        pm=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)  arr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        DFS(0,arr);
        System.out.println(sb);
    }
}
