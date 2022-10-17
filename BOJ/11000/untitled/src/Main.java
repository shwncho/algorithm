import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Room implements Comparable<Room>{
    public int s;
    public int e;

    Room(int s, int e){
        this.s=s;
        this.e=e;
    }

    @Override
    public int compareTo(Room o){
        if(this.s==o.s) return this.e-o.e;
        else return this.s-o.s;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Room> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Room(a,b));
        }

        Collections.sort(list);

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        pQ.add(list.get(0).e);



        for(int i=1; i<n; i++){
            if(pQ.peek()<=list.get(i).s){
                pQ.poll();
            }
            pQ.add(list.get(i).e);
        }

        System.out.println(pQ.size());

    }
}
