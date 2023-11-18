import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int [N+2];
        for(int i=1; i<N+1; i++)    arr[i]=Integer.parseInt(st.nextToken());
        arr[N+1]=L;
        Arrays.sort(arr);
        System.out.println(binarySearch(arr,M,L));

    }

    public static int binarySearch(int[] arr, int M, int L){
        int left = 1;
        int right = L-1;
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;

            if(check(arr,mid) > M){
                left = mid+1;
            }
            else{
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }


    public static int check(int[] arr, int mid){
        int cnt = 0;
        for(int i=1; i<arr.length; i++){
            //이미 설치된 곳에는 설치할 수 없으므로 부등호에서 제외하기위해 -1
            cnt+= (arr[i] - arr[i-1] - 1) / mid;
        }
        return cnt;
    }
}
