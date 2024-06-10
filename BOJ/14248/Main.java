import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        visited[s]=true;
        DFS(s,arr,n);
        int answer = 0;
        for(int i=1; i<=n; i++) if(visited[i])  answer++;

        System.out.println(answer);
    }

    private static void DFS(int pos, int[] arr, int n){
        if(pos+arr[pos]<=n){
            if(!visited[pos+arr[pos]]){
                visited[pos+arr[pos]]=true;
                DFS(pos+arr[pos],arr,n);
            }
        }

        if(pos-arr[pos]>=1){
            if(!visited[pos-arr[pos]]){
                visited[pos-arr[pos]]=true;
                DFS(pos-arr[pos],arr,n);
            }
        }
    }
}
