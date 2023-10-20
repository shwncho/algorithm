import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n  =Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        solution(n, k);

    }

    public static void solution(int n, long k) {
        long left = 0;
        long right = n /2;

        while(left<=right){
            long mid = (left+right)/2;
            long target = (mid+1)*(n -mid+1);

            if(target > k){
                right = mid -1;
            }
            else if(target < k){
                left = mid +1;
            }
            else{
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
