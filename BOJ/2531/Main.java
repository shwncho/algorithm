import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        //먹을 수 있는 초밥 종류 배열, 총 3000종류가 최대
        int[] arr = new int[d+1];
        //쿠폰 초밥
        arr[c] = 30000;
        //쿠폰 초밥 1개 보장
        int cnt = 1;

        int[] sushi = new int[N];
        for(int i=0; i<N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        //회전하지 않은 처음 상태
        for(int i=0; i<k; i++){
            int id = sushi[i];
            //초밥 종류 카운트
            if(arr[id]==0)  cnt++;
            arr[id]++;
        }


        int answer = cnt;
        for(int i=0; i<N-1; i++){
            int startId = sushi[i];
            int endId = sushi[i+k < N ? i+k : (i+k)%N];

            if(--arr[startId]==0)   cnt--;
            if(++arr[endId]==1) cnt++;

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
        br.close();
    }
}
