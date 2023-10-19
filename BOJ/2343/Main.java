import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=arr[i];
            max = Math.max(arr[i], max);
        }

        long left = max;
        long right = sum;
        long answer = 0;
        while(left<=right){
            long mid = (left + right)/2;

            if(check(arr,mid)>M){
                left = mid + 1;
            }
            else right = mid - 1;
        }
        answer = left;
        System.out.println(answer);
    }

    public static long check(int[] arr, long mid){
        long sum = 0;
        long cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(sum+arr[i]>mid){
                sum=0;
                cnt++;
            }
            sum+=arr[i];
        }
        //마지막 남은 수 체크
        if(sum>0)   cnt++;
        return cnt;
    }
}
