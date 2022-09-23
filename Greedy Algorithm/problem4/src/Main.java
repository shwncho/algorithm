import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
    public int money, day;
    Lecture(int money, int day){
        this.money=money;
        this.day=day;
    }

    @Override
    public int compareTo(Lecture o){
        return o.day-this.day;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Lecture> list = new ArrayList<>();
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int max = Integer.MIN_VALUE;
        int j=0,answer=0;

        int n =sc.nextInt();
        for(int i=0; i<n; i++){
            int m = sc.nextInt();
            int d = sc.nextInt();
            list.add(new Lecture(m,d));
            if(d>max)   max=d;
        }

        Collections.sort(list);

        for(int i=max; i>=1; i--){
            //이전 j값을 유지하기위해 바깥에 j값을 초기화
            for( ; j<n; j++){
                if(list.get(j).day<i)   break;
                pQ.offer(list.get(j).money);
            }
            if(!pQ.isEmpty())   answer+=pQ.poll();
        }

        System.out.println(answer);


    }
}
