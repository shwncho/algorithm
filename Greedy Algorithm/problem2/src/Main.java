import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Room implements Comparable<Room>{
    public int s,e;
    Room(int s, int e){
        this.s=s;
        this.e=e;
    }

    @Override
    public int compareTo(Room r){
        return this.e-r.e;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();

        ArrayList<Room> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Room(a,b));
        }

        Collections.sort(list);

        int answer=1;
        int std=list.get(0).e;

        for(Room r : list){
            if(r.s>=std){
                answer++;
                std=r.e;
            }
        }

        System.out.println(answer);
    }
}
