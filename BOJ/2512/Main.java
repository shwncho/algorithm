import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());

        int left = 0;
        int right = M;
        int answer = 0;
        while(left<=right){
            int mid = (left + right) / 2;

            if(check(arr,mid)<=M && mid<=arr[N-1]){
                answer = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        System.out.println(answer);

    }

    public static long check(int[] arr, int mid){
        long sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=mid) sum+=arr[i];
            else sum+=mid;
        }
        return sum;
    }
}
