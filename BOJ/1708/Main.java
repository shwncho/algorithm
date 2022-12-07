import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Point{
    public long x;
    public long y;
    Point(long x, long y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    static Point p0 = new Point(0,0);
    public static Point nextToTop(Stack<Point> S){
        return S.get(S.size()-2);
    }

    public static long distSq(Point p1, Point p2){
        return ((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
    }

    public static int orientation(Point p, Point q, Point r){
        long val = ((q.y-p.y)*(r.x-q.x)-(q.x-p.x)*(r.y-q.y));
        if(val==0)  return 0;
        else if(val>0)  return 1;
        else    return 2;
    }

    public static int compare(Point p1, Point p2){
        int o = orientation(p0,p1,p2);
        if(o==0) {
            if (distSq(p0, p2) >= distSq(p0, p1)) return -1;
            else return 1;
        }
        else{
            if(o==2)    return -1;
            else return 1;
        }
    }

    public static void convexHull(Point[] points, int n){
        long ymin = points[0].y;
        int min = 0;
        for(int i=1; i<n; i++){
            long y = points[i].y;

            if(y<ymin || (ymin==y && points[i].x < points[min].x)){
                ymin=points[i].y;
                min =i;
            }
        }

        Point tmp = points[0];
        points[0]=points[min];
        points[min]=tmp;

        p0=points[0];

        Arrays.sort(points,Main::compare);

        int m = 1;

        for(int i=1; i<n; i++){
            while((i<n-1) && (orientation(p0,points[i],points[i+1])==0)) i++;
            points[m]=points[i];
            m++;
        }

        if(m<3) return;

        Stack<Point> S=new Stack<>();
        S.push(points[0]);
        S.push(points[1]);
        S.push(points[2]);


        for(int i=3; i<m; i++){
            while((S.size()>1) && (orientation(nextToTop(S),S.get(S.size()-1),points[i])!=2))   S.pop();
            S.push(points[i]);
        }

        System.out.println(S.size());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        Point[] points = new Point[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a =Long.parseLong(st.nextToken());
            long b =Long.parseLong(st.nextToken());

            points[i]=new Point(a,b);
        }

        convexHull(points, points.length);
    }
}

