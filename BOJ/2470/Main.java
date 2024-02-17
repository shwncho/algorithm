import java.io.*;
import java.util.*;

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
        Arrays.sort(arr);

        int s = 0;
        int e = N-1;
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;
        while(s<e){
            int sum = arr[s]+arr[e];
            if(min > Math.abs(sum)){
                result[0]=arr[s];
                result[1]=arr[e];

                if(sum==0) break;
                min = Math.abs(sum);
            }
            if(sum < 0) s++;
            else e--;
        }

        System.out.println(result[0] + " " + result[1]);


    }
}
