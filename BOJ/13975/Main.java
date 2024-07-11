import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-->0){
            int k = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            Queue<Long> q = new PriorityQueue<>();
            for(int i=0; i<k; i++){
                q.offer(Long.parseLong(st.nextToken()));
            }

            long answer = 0;
            while(!q.isEmpty()){
                if(q.size()==1) break;

                long first = q.poll();
                long second = q.poll();

                answer += first + second;
                q.offer(first + second);

            }

            sb.append(answer).append("\n");


        }

        System.out.println(sb);
    }
}
