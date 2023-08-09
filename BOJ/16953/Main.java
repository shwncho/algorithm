import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int BFS(long a, long b){
        Queue<Long> Q = new LinkedList<>();
        Q.offer(a);
        int L = 0;
        while(!Q.isEmpty()){

            int len = Q.size();

            for(int i=0; i<len; i++){

                long value = Q.poll();

                if(value == b) return L+1;

                if(value * 2 <= b){
                    Q.offer(value*2);
                }

                if(value*10+1 <= b){
                    Q.offer(value*10+1);
                }
            }
            L++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if(a==b) System.out.println(0);
        else System.out.println(BFS(a,b));


    }
}
