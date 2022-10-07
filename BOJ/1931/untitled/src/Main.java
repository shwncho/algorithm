import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
        return this.e==o.e ? this.s-o.s : this.e-o.e;
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());

        ArrayList<Room> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Room(s,e));
        }

        Collections.sort(list);

        int cnt=list.get(0).s==list.get(0).e ? 0 : 1;
        int std = list.get(0).e;
        for(Room o : list){
            if(o.s>=std){
                cnt++;
                std=o.e;
            }
        }

        System.out.println(cnt);
    }
}
