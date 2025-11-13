import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int right = Integer.MAX_VALUE;

        int answer = 0;

        while(left<=right) {
            int mid = left + (right - left)/2;
            if(check(arr,mid) >= K) {
                answer = mid;
                left = mid +1;
            }
            else    right = mid - 1;
        }


        System.out.println(answer);
    }

    private static int check(int[] arr, int mid) {
        int cnt = 0;
        for(int a : arr) cnt += a/mid;

        return cnt;
    }
}
