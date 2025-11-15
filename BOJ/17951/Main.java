import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int left = 0;
        int right = 10_000_000;

        while(left<=right) {
            int mid = (left + right) / 2;

            if(check(arr,mid)>=K) {
                answer = mid;
                left = mid + 1;
            }
            else    right = mid - 1;
        }

        System.out.println(answer);

    }

    private static int check(int[] arr, int mid) {
        int cnt = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(sum>=mid){
                cnt++;
                sum=0;
            }
        }

        return cnt;
    }
}
