import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] sum = new int[N+1];
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)  arr[i] = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            sum[i] = sum[i-1] + arr[i];
        }

        for(int i=K; i<=N; i++){
            list.add(sum[i]-sum[i-K]);
        }
        System.out.println(Collections.max(list));

    }
}
