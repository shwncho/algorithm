import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[S];

        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long left = 1;
        long right = 1_000_000_000;

        long maxLen = 0;

        while(left<=right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for(int i=0; i<S; i++) {
                cnt += arr[i] / mid;
            }

            if(cnt >= C){
                left = mid +1;
                maxLen = mid;
            }
            else right = mid -1;
        }
        long cnt = 0;
        for(int i=0; i<S; i++) {
            cnt += arr[i] / maxLen;
        }

        long sum = 0;
        for(int i=0; i<S; i++) {
            sum += arr[i] % maxLen;
        }

        if(cnt>C) sum+=(cnt -C)*maxLen;
        System.out.println(sum);


    }
}
