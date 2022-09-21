import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
    public int t;
    public char s;
    Time(int t, char s){
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(Time o){
        if(this.t==o.t) return this.s-o.s;
        return this.t-o.t;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Time> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            list.add(new Time(a,'s'));
            int b = sc.nextInt();
            list.add(new Time(b,'e'));
        }

        Collections.sort(list);

        int cnt=0;
        int answer=Integer.MIN_VALUE;

        for(Time o : list){
            if(o.s=='s')    cnt++;
            else if(o.s=='e')   cnt--;

            answer=Math.max(answer,cnt);
        }

        System.out.println(answer);
    }

}
