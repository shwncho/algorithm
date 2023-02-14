import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
    public int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Point p){
        if(this.y == p.y)   return this.x-p.x;
        return this.y-p.y;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n =Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Point(a,b));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(Point p : list){
            sb.append(p.x + " " + p.y).append("\n");
        }
        System.out.println(sb);

    }
}
