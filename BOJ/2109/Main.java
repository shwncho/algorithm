import java.io.*;
import java.util.*;
public class Main {
    static class Lecture{
        int p,d;
        Lecture(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        List<Lecture> lectures = new ArrayList<>();
        Queue<Integer> pQ = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(p, d));
        }

        Collections.sort(lectures, (a,b) -> a.d - b.d);

        for(Lecture l : lectures) {
            pQ.offer(l.p);
            if(pQ.size() > l.d) pQ.poll();
        }

        while(!pQ.isEmpty())    answer+=pQ.poll();
        System.out.println(answer);
    }
}
