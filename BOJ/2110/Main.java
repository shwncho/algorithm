import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, n, c));

    }

    public static int binarySearch(int[] arr, int n , int c){
        int answer = 0;
        int left = 1;
        int right = arr[n-1] - arr[0];

        while(left<=right){
            int mid = (left + right) / 2;
            if(check(arr, mid, n)>=c){
                answer = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return answer;
    }

    public static int check(int[] arr, int mid, int n){
        int prev = arr[0];
        int cnt = 0;

        for(int i=1; i<n; i++){
            if(arr[i] - prev < mid) cnt++;
            else prev = arr[i];
        }

        return n - cnt;
    }

}
