import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int cnt=0;
    static int[] graph;
    public static void DFS(int x){
        if(x==n){
            cnt++;
            return;
        }

        for(int i=0; i<n; i++){
            graph[x]=i;
            if(promising(x))    DFS(x+1);
        }
    }

    public static boolean promising(int x){
        for(int i=0; i<x; i++){
            if(graph[x]==graph[i] || x-i == Math.abs(graph[x]-graph[i]))    return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph=new int[n];
        DFS(0);
        System.out.println(cnt);


    }
}
