import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] gems = new int[M];
        int max = 0;
        for(int i=0; i<M; i++){
            gems[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,gems[i]);
        }

        int left = 1;
        int right = max;

        int answer = 0;
        while(left<=right){
            int mid = (left + right) / 2;

            int cnt = 0;
            for(int i=0; i<M; i++){
                cnt+=gems[i]/mid;
                if(gems[i]%mid!=0)  cnt++;
            }

            if(N<cnt)   left = mid + 1;
            else{
                answer = mid;
                right = mid-1;
            }
        }

        System.out.println(answer);
    }
}
