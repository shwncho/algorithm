import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = N-1;
        int min = Integer.MAX_VALUE;
        while(s<e){
            int value = arr[s] + arr[e];

            if(Math.abs(min) > Math.abs(value)) min = value;

            if(value < 0)   s++;
            else    e--;
        }

        System.out.println(min);
    }
}
