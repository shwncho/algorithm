import java.io.*;
public class Main {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long k = Long.parseLong(br.readLine());

        arr = new long[61];
        arr[0]=1;
        for(int i=1; i<61; i++){
            arr[i] = arr[i-1]*2;
        }

        System.out.println(solution(k));
    }
    public static long solution(long n){
        if(n==1)    return 0;
        for(int i=0; i<61; i++){
            if(arr[i] >=n ) return 1-solution(n-arr[i-1]);
        }
        return 0;
    }
}
