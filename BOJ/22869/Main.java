import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];
        visited[0] = true;
        for(int i=0; i<N-1; i++){
            if(!visited[i]) continue;
            for(int j=i+1; j<N; j++){
                int value = (j-i) * (1+ Math.abs(arr[i] - arr[j]));
                if(value<=K)    visited[j] = true;
            }
        }

        System.out.println(visited[N-1] ? "YES" : "NO");
    }
}
