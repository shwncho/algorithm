import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Point p){
        if(this.x == p.x)    return this.y-p.y;
        return this.x-p.x;
    }

}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Point> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Point(a,b));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for(Point p : list){
            sb.append(p.x+" "+p.y).append("\n");
        }

        System.out.println(sb);

    }
}
