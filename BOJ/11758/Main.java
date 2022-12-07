import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point{
    public int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    static int CCW(Point[] points){
        int val = (points[1].y-points[0].y)*(points[2].x-points[1].x)
                -(points[1].x-points[0].x)*(points[2].y-points[1].y);

        return Integer.compare(0, val);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Point[] p = new Point[3];
        for(int i=0; i<3; i++){
            st=new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            p[i]=new Point(a,b);
        }
        System.out.println(CCW(p));


    }
}
