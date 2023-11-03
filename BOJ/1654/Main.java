import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        for(int i=0; i<k; i++)  arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        long left = 1;
        long right = arr[k-1];
        long answer=0;
        while(left<=right){
            long mid = (left + right)/2;

            if(check(arr,mid)>=n){
                answer = mid;
                left = mid+1;
            }
            else right = mid-1;
        }

        System.out.println(answer);
    }

    public static long check(int[] arr, long mid){
        long cnt = 0;
        for(int i=0; i<arr.length; i++){
            cnt+=arr[i]/mid;
        }
        return cnt;
    }
}
