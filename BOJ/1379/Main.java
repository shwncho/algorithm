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

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Room> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Room(idx, s, e));

        }

        int[] arr = new int[n+1];
        int answer=0;
        //일찍 시작하는 강의 순서로 오름차순
        Collections.sort(list);

        PriorityQueue<Room> pQ = new PriorityQueue<>((r1,r2)->(r1.e-r2.e));

        for(int i=0; i<n; i++){
            if(!pQ.isEmpty() && pQ.peek().e<=list.get(i).s){
                arr[list.get(i).idx] = arr[pQ.peek().idx];
                pQ.poll();
            }
            else{
                answer++;
                arr[list.get(i).idx] = answer;
            }
            pQ.offer(list.get(i));
        }

        System.out.println(answer);
        for(int i=1; i<=n; i++){
            System.out.println(arr[i]);
        }
    }
}
