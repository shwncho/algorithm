import java.io.*;
import java.util.*;

class Point{
    public int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }

}
public class Main {
    static Point[] points;
    static int distance(Point p1, Point p2){
        return (p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y);
    }
    static int bruteForceFair(int l, int r){
        int min = Integer.MAX_VALUE;
        for(int i=l; i<r; i++){
            Point tmp=points[i];
            for(int j=i+1; j<=r; j++){
                int dis = distance(tmp,points[j]);
                min=Math.min(min,dis);
            }
        }
        return min;
    }
    static int closestPair(int l, int r){
        if(r-l+1<=3)    return bruteForceFair(l,r);
        int q = (l+r)/2;
        int dl =closestPair(l,q-1);
        int dr = closestPair(q,r);
        int d = Math.min(dl,dr);
        ArrayList<Point> S=new ArrayList<>();

        for(int i=l; i<=r; i++){
            if(Math.pow(points[q].x-points[i].x,2)<=d){
                S.add(points[i]);
            }
        }
        Collections.sort(S, (o1, o2) -> o1.y-o2.y);
        for (int i = 0; i < S.size() - 1; i++) {
            //범위에 들어오는 점이 7개 이하이기 때문에 7번 이상 반복할 필요없음
            if(S.size()>i+7){
                for (int j = i + 1; j < i+8; j++) {
                    int y = S.get(i).y - S.get(j).y;
                    if (y * y < d) {
                        d = Math.min(distance(S.get(i), S.get(j)), d);
                    }
                    else {
                        break;
                    }
                }
            }
            else {
                for (int j = i + 1; j < S.size(); j++) {
                    int y = S.get(i).y - S.get(j).y;
                    if (y * y < d) {
                        d = Math.min(distance(S.get(i), S.get(j)), d);
                    } else {
                        break;
                    }
                }
            }
        }
        return d;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        points=new Point[n];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            points[i]=new Point(a,b);
        }
        Arrays.sort(points, (o1, o2) -> o1.x-o2.x);

        bw.write(String.valueOf(closestPair(0,n-1)));
        bw.flush();

        br.close();
        bw.close();
    }
}
