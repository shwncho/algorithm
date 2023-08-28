import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Integer[] A = new Integer[n];
        Integer[] B = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A,Collections.reverseOrder());
        Arrays.sort(B);

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += A[i] * B[i];
        }

        System.out.println(sum);



    }

}
