import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());
        double cnt = 0;
        double sum = 0;

        for(int i=0; i<N; i++){
            int a,b;
            if(arr[i]>X){
                a=arr[i];
                b=X;
            }
            else{
                a=X;
                b=arr[i];
            }
            if(gcd(a,b)==1){
                cnt++;
                sum+=arr[i];
            }
        }

        System.out.println(sum/cnt);

    }

    private static int gcd(int a, int b){
        while(b>0){
            int tmp = a;
            a = b;
            b = tmp%b;
        }

        return a;
    }
}
