import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        //최대 방문자 수
        int max = 0;
        //구간 개수
        int cnt = 0;

        int start = 0;
        for(int i=X; i<=N; i++){
            max = Math.max(arr[i]-arr[start++],max);
        }

        if(max==0) System.out.println("SAD");
        else{
            start = 0;
            for(int i=X; i<=N; i++){
                if(arr[i]-arr[start++]==max)    cnt++;
            }
            System.out.println(max);
            System.out.println(cnt);
        }

    }
}
