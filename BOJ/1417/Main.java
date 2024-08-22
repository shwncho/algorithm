import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int std = 0;
        for(int i=0; i<N; i++){
            int val = Integer.parseInt(br.readLine());
            if(i==0)    std = val;
            else pQ.offer(val);
        }

        int answer = 0;
        while(!pQ.isEmpty()){
            if(pQ.peek() < std) break;
            else{
                pQ.offer(pQ.poll()-1);
                std++;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
