import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Long> pQ = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)  pQ.offer(Long.parseLong(st.nextToken()));

        for(int i=0; i<m; i++){
            long n1 = pQ.poll();
            long n2 = pQ.poll();

            long val = n1+n2;
            pQ.offer(val);
            pQ.offer(val);
        }

        long sum = 0;
        while(!pQ.isEmpty())    sum+=pQ.poll();

        System.out.println(sum);
    }
}
