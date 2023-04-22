import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[2*n];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer=Integer.MAX_VALUE;
        for(int i=0; i<=n-1; i++){
            answer=Math.min(answer,arr[i]+arr[2*n-1-i]);
        }

        System.out.println(answer);

    }
}
