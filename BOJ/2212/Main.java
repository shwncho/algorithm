import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int[] result = new int [N-1];
        for(int i=0; i<N-1; i++)    result[i] = arr[i+1] - arr[i];

        Arrays.sort(result);

        int answer = 0;
        for(int i=0; i<N-K; i++)    answer+=result[i];

        System.out.println(answer);
    }
}
