import java.util.*;
import java.io.*;
class Work implements Comparable<Work>{
    public int t,s;
    Work(int t, int s){
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(Work w){
        return w.s - this.s;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Work> works = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            works.add(new Work(t,s));
        }

        int start = works.peek().s;
        while(!works.isEmpty()){
            Work tmp = works.poll();
            if(start < tmp.s)    start-=tmp.t;
            else start=tmp.s - tmp.t;
        }

        if(start<0) System.out.println(-1);
        else System.out.println(start);
    }
}
