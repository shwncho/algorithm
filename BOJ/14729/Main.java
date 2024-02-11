import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Float> pQ = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pQ.offer(Float.parseFloat(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<7; i++){
            sb.append(String.format("%.3f",pQ.poll())).append("\n");
        }

        System.out.println(sb);
    }
}
