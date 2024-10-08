import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int N = Integer.parseInt(br.readLine());

            int answer = Integer.MIN_VALUE;
            int nowMax = 0;

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int num = Integer.parseInt(st.nextToken());
                nowMax = Math.max(nowMax + num, num);
                answer = Math.max(answer, nowMax);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
