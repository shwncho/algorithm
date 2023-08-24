import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] sum = new int[n];
        int answer = 0;
        for(int i=0; i<n; i++){
            if(i==0)    sum[0]=arr[0];
            else    sum[i]=sum[i-1]+arr[i];
            answer+=sum[i];
        }

        System.out.println(answer);
    }
}