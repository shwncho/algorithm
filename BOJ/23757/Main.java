import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pQ.add(Integer.parseInt(st.nextToken()));
        }

        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int now = pQ.poll();
            int wanted = Integer.parseInt(st.nextToken());
            if(now < wanted){
                flag = false;
                break;
            }
            else if(now > wanted){
                pQ.add(now - wanted);
            }
        }


        if(flag) System.out.println(1);
        else System.out.println(0);
    }
}
