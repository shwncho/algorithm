import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer =0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int left = arr[0];
        // 캐릭터들이 가질 수 있는 레벨 중 가장 큰 값
        int right = arr[N-1]+K;

        while(left<=right){
            int mid = (left + right)/2;
            //최소 레벨의 기준(=mid)을 K로 올렸을 때
            if(solve(arr,mid)<=K){
                answer=mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        System.out.println(answer);
    }

    private static long solve(int[] arr, int mid){
        long diff = 0;
        for(int x : arr){
            if(x<mid)   diff+=mid-x;
            else break;
        }
        return diff;
    }
}
