import java.io.*;
import java.util.*;
class Assignment implements Comparable<Assignment>{
    public int d,t;
    Assignment(int d, int t){
        this.d=d;
        this.t=t;
    }

    @Override
    public int compareTo(Assignment a){
        return a.t - this.t;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n =Integer.parseInt(br.readLine());

        PriorityQueue<Assignment> pQ = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            pQ.add(new Assignment(d,t));
        }


        int start = pQ.peek().t;
        while(!pQ.isEmpty()){
            Assignment tmp = pQ.poll();
            if(start < tmp.t)   start -= tmp.d;
            else start = tmp.t - tmp.d;
        }

        System.out.println(start);

    }
}
