import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point{
    public int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    static int N,M,len, answer=Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pz,hs;

    public static void DFS(int L, int s){
        if(L==M){
            int sum=0;
            for(Point h : hs){
                int dis=Integer.MAX_VALUE;
                //피자집의 ArrayList 인덱스 번호 i
                for(int i : combi){
                    dis=Math.min(dis, Math.abs(h.x-pz.get(i).x)+Math.abs(h.y-pz.get(i).y));
                }
                sum+=dis;
            }
            answer=Math.min(answer, sum);
        }
        else{
            for(int i=s; i<len; i++){
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pz=new ArrayList<>();
        hs=new ArrayList<>();

        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp ==1) hs.add(new Point(i,j));
                else if(tmp==2) pz.add(new Point(i,j));
            }
        }
        len = pz.size();
        combi = new int[M];
        DFS(0,0);
        System.out.println(answer);
    }
}
