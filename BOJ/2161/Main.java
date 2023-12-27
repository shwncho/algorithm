import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++) q.offer(i);
        int num = 1;

        while(q.size()!=1){
            int tmp;
            if(num%2==0){
                tmp = q.poll();
                q.offer(tmp);
            }
            else{
                tmp = q.poll();
                list.add(tmp);
            }
            num++;
        }
        list.add(q.poll());

        for(int x : list){
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
}
