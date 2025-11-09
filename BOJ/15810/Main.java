import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)  arr[i] = Integer.parseInt(st.nextToken());

        long left = 1;
        long right = (long)Arrays.stream(arr).max().getAsInt() * M;

        while(left <= right) {
            long mid = (left + right)/2;

            if(check(arr,mid)<M){
                left = mid + 1;
            }
            else{
                answer = mid;
                right = mid -1;
            }
        }

        System.out.println(answer);
    }

    private static long check(int[] arr, long mid) {
        long cnt = 0;
        for(int i=0;i<arr.length;i++) {
            cnt+= mid / arr[i];
        }
        return cnt;
    }
}
