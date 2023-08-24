import java.util.*;
import java.io.*;
class Point{
    public int zero, one;
    Point(int zero, int one){
        this.zero = zero;
        this.one = one;
    }

    public int getZero() {
        return zero;
    }

    public int getOne() {
        return one;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        Point[] p = new Point[41];

        p[0] = new Point(1,0);
        p[1] = new Point(0,1);

        for(int i=2; i<41; i++){

            p[i] = new Point(p[i-1].getZero() + p[i-2].getZero(), p[i-1].getOne() + p[i-2].getOne());
        }

        StringBuilder sb = new StringBuilder();
        while(t-->0){
            int n = Integer.parseInt(br.readLine());

            sb.append(p[n].getZero()).append(" ");
            sb.append(p[n].getOne()).append("\n");

        }

        System.out.println(sb);

    }
}
