import java.io.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Line implements Comparable<Line>{
    public int x,y;
    Line(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Line l){
        if(this.x==l.x) return this.y-l.y;
        return this.x-l.x;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        ArrayList<Line> lines = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lines.add(new Line(x,y));
        }

        Collections.sort(lines);

        int answer = lines.get(0).y - lines.get(0).x;
        Line tmp = lines.get(0);
        int cy = tmp.y;

        for(Line l : lines){
            if(l.x <= cy && l.y >= cy){
                answer+=l.y - cy;
                cy = l.y;
            }
            else if(cy < l.x){
                answer+=l.y - l.x;
                cy = l.y;
            }
        }

        System.out.println(answer);
    }
}
