import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr =new int[N];
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum+=num;
            max = Math.max(max,num);
        }

        int left = max;
        int right = sum;
        while(left<=right){
            int mid = (left + right)/2;

            if(check(arr, mid) > M){
                left = mid + 1;
            }
            else right = mid -1;
        }

        System.out.println(left);
    }

    public static int check(int[] arr, int mid){
        int sum = 0;
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(sum + arr[i] > mid){
                sum = 0;
                cnt++;
            }
            sum+=arr[i];
        }

        if(sum>0)   cnt++;

        return cnt;
    }
}
