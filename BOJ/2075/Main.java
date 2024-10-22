import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                pQ.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i<N-1; i++)    pQ.poll();
        System.out.println(pQ.poll());
    }
}
