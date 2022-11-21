import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] ch,pm;
    static StringBuilder sb=new StringBuilder();
    static void DFS(int L, int[] arr){
        if(L==m){
            if(isIncreasingOrder(pm)){
                for (int x : pm) {
                    sb.append(x+" ");
                }
                sb.append("\n");
            }
        }
        else{
            for(int i=0; i<n; i++){
                pm[L]=arr[i];
                DFS(L+1,arr);
            }
        }
    }
    static boolean isIncreasingOrder(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]>arr[i+1]) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        ch=new int[n];
        pm=new int[m];
        for(int i=0; i<n; i++)  arr[i]=i+1;

        DFS(0,arr);
        System.out.println(sb);
    }
}