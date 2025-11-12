import java.io.*;
import java.util.*;
public class Main {
    static class Assignment {
        int d,w;
        Assignment(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Assignment> assignments = new ArrayList<>();
        Queue<Integer> pQ = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            assignments.add(new Assignment(d, w));
        }

        Collections.sort(assignments, (a,b) -> (a.d-b.d));

        int answer = 0;
        for(Assignment a : assignments){
            pQ.offer(a.w);
            if(pQ.size() > a.d) pQ.poll();
        }

        while(!pQ.isEmpty())    answer+=pQ.poll();

        System.out.println(answer);
    }
}
