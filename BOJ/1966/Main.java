import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int idx, priority;
    Point(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Point> Q = new LinkedList<>();

            int idx = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                int num = Integer.parseInt(st.nextToken());
                Q.offer(new Point(idx++,num));
            }

            int max = maxPriority(Q);
            int out = 1;
            while(!Q.isEmpty()){
                Point p = Q.poll();
                if(p.priority == max){
                    if(p.idx == m){
                        sb.append(out).append("\n");
                    }
                    max = maxPriority(Q);
                    out++;
                }
                else Q.offer(p);
            }
        }
        System.out.println(sb);
    }

    private static int maxPriority(Queue<Point> queue){
        int max = Integer.MIN_VALUE;
        for(Point p : queue){
            if( p.priority > max)   max = p.priority;
        }
        return max;
    }
}
