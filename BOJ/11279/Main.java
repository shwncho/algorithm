import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int value = Integer.parseInt(br.readLine());

            if(value==0 && pQ.isEmpty())    sb.append(0).append("\n");
            else if(value==0){
                sb.append(pQ.poll()).append("\n");
            }
            else pQ.offer(value);

        }

        System.out.println(sb);
    }
}
