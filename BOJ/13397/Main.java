import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = 0;
        int answer = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        //최솟값을 기준으로 탐색
        while(left <= right){
            int mid = (left + right)/2;
            if(count(mid,N,arr)<=M){
                answer = mid;
                right = mid - 1;
            }
            else left = mid+1;

        }

        System.out.println(answer);
    }

    private static int count(int mid, int N,int[] arr){
        int cnt = 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
            //최솟값 기준을 넘은 구간 발견
            if(max - min > mid){
                cnt++;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                i--;
            }
        }
        return cnt;
    }
}
