import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[] arr;
    static int[] pm;
    static boolean[] visited;
    static int answer;
    public static void DFS(int L){
        if(L==n){
            answer=Math.max(answer,difference());
        }
        else{
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    visited[i]=true;
                    pm[L]=arr[i];
                    DFS(L+1);
                    visited[i]=false;
                }
            }
        }
    }
    public static int difference(){
        int sum=0;

        for(int i=0; i<n-1; i++){
            sum+=Math.abs(pm[i]-pm[i+1]);
        }
        return sum;
    }
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        pm = new int[n];
        visited = new boolean[n];
        st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        DFS(0);

        System.out.println(answer);
    }
}