import java.util.*;
import java.io.*;
class Room implements Comparable<Room>{
    public int idx,s,e;
    Room(int idx, int s, int e){
        this.idx=idx;
        this.s=s;
        this.e=e;
    }

    @Override
    public int compareTo(Room r){
        return this.s-r.s;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Room> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Room(idx, s, e));
        }

        Collections.sort(list);

        int answer = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            while(!pQ.isEmpty() && pQ.peek()<=list.get(i).s){
                pQ.poll();
            }

            pQ.offer(list.get(i).e);
            answer=Math.max(answer,pQ.size());
        }

        System.out.println(answer);

    }
}
