import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;

        int sum = 0;
        while(true){
            //right가 N이 되는 순간 마지막 구간을 고려해야하므로 if 문의 순서 고려
            if(sum>=M){
                sum -= arr[left++];
            }
            else if(right==N)   break;
            else sum += arr[right++];

            if(sum==M)  answer++;
        }


        System.out.println(answer);

        br.close();
    }
}
