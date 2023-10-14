import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] result = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N-1; i++)    result[i] = arr[i+1]-arr[i];

        Arrays.sort(result);

        int answer = 0;
        for(int i=0; i<N-K; i++){
            answer += result[i];
        }

        System.out.println(answer);

    }
}
