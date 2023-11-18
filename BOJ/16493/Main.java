import java.util.*;
import java.io.*;

class  Chapter{
    public int day,page;
    Chapter(int day, int page){
        this.day = day;
        this.page = page;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Chapter[] chapters = new Chapter[M];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int page = Integer.parseInt(st.nextToken());
            chapters[i] = new Chapter(day,page);
        }
        int[] dp = new int[N+1];
        for(int i=0; i<M; i++){
            for(int j=N; j>=chapters[i].day; j--){
                dp[j] = Math.max(dp[j], dp[j-chapters[i].day]+chapters[i].page);
            }
        }

        System.out.println(dp[N]);
    }
}
