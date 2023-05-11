import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int t = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++){
            q.offer(i);
        }

        int[] arr = new int[n];
        int idx = 0;
        while(!q.isEmpty()){
            int num = q.poll();
            t++;
            if(t%k==0){
                arr[idx]=num;
                idx++;
            }
            else q.offer(num);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<").append(arr[0]);

        for(int i=1; i<n; i++){
            sb.append(", ").append(arr[i]);
        }
        sb.append(">");

        System.out.println(sb);






    }
}
