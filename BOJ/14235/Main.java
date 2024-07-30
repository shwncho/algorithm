import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a==0 && pQ.isEmpty())    sb.append(-1).append("\n");
            else if(a==0 && !pQ.isEmpty())  sb.append(pQ.poll()).append("\n");
            else{
                for(int j=0; j<a; j++){
                    int val = Integer.parseInt(st.nextToken());
                    pQ.offer(val);
                }
            }
        }

        System.out.println(sb);
    }
}
