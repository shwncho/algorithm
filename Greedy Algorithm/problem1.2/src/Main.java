import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body>{
    public int h,w;
    Body(int h, int w){
        this.h=h;
        this.w=w;
    }

    @Override
    public int compareTo(Body o){
        //내림차순
        return o.h-this.h;
    }
}
public class Main {
    static int solution(ArrayList<Body> list, int n){
        int cnt=0;
        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        for(Body o : list){
            if(o.w>max){
                cnt++;
                max=o.w;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        ArrayList<Body> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int h=sc.nextInt();
            int w=sc.nextInt();
            list.add(new Body(h,w));
        }
        System.out.println(solution(list,n));
    }
}
