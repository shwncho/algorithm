import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(Long.parseLong(br.readLine()));
        }

        Long answer=0L;
        while(pq.size()>1){
            long n1 = pq.poll();
            long n2 = pq.poll();
            answer+=n1+n2;
            pq.add(n1+n2);
        }
        System.out.println(answer);



    }
}
