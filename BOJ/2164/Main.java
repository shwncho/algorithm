import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q =  new LinkedList<>();
        for(int i=1; i<=N; i++) q.add(i);

        int num = 1;
        while(q.size()!=1){
            if(num%2==0){
                int tmp = q.poll();
                q.offer(tmp);
            }
            else{
                q.poll();
            }
            num++;
        }

        System.out.println(q.poll());

    }
}
