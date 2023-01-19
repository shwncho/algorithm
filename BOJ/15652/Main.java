import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] ch,pm,arr;
    static StringBuilder sb=new StringBuilder();
    static void DFS(int L, int s){
        if(L==m){
            for (int x : pm) {
                sb.append(x+" ");
            }
            sb.append("\n");
        }
        else{
            for(int i=s; i<n; i++){
                pm[L]=arr[i];
                DFS(L+1,i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr = new int[n];
        ch=new int[n];
        pm=new int[m];
        for(int i=0; i<n; i++)  arr[i]=i+1;

        DFS(0,0);
        System.out.println(sb);
    }
}