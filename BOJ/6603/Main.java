import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[] arr,combi;
    static StringBuilder sb = new StringBuilder();
    public static void DFS(int L, int s){
        if(L==6){
            for(int x : combi){
                sb.append(x+" ");
            }
            sb.append("\n");
        }
        else{
            for(int i=s; i<n; i++){
                combi[L]=arr[i];
                DFS(L+1,i+1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st=new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            if(n==0)    break;

            arr= new int[n];
            combi = new int[6];
            for(int i=0; i<n; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            DFS(0,0);
            sb.append("\n");

        }
        System.out.println(sb);
        br.close();
    }
}