import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        System.out.println(binarySearch(N, M,arr));


    }

    private static int binarySearch(int N,int M, int[] arr){
        int left = 1;
        int right = arr[N-1];

        int answer = 0;
        while(left<=right){
            int mid = (left + right) / 2;
            if(solve(mid,arr)>=M){
                answer = mid;
                left = mid + 1;
            }
            else right = mid -1;
        }
        return answer;
    }

    private static int solve(int mid, int[] arr){
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            cnt+=arr[i]/mid;
        }
        return cnt;

    }
}
