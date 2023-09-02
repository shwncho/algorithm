import java.io.*;
import java.util.StringTokenizer;

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



        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long answer = N;

        for(int i=0; i<N; i++){
            if(arr[i]>=B)    arr[i]-=B;
            else arr[i]=0;
        }

        for(int i=0; i<N; i++){
            if(arr[i]>0){
                if(arr[i]%C==0){
                    answer+=arr[i]/C;
                }
                else answer+=arr[i]/C +1;
            }
        }

        System.out.println(answer);


    }
}
