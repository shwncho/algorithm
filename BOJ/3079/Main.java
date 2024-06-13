import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long left = arr[0];
        long right = M * arr[N-1];

        long answer = 0;

        while(left<=right){
            long mid = (left + right) / 2;

            long sum=0;
            for(long value : arr){
                sum += mid / value;
                //여기서 break를 안걸어주면 10^9 * 10^9 범위로 오버플로우 가능성 존재
                if(sum>M)   break;
            }

            if(sum>=M){
                answer = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
