import java.util.*;
import java.io.*;
class Point implements Comparable<Point>{
    public int n,cnt;

    Point(int n, int cnt){
        this.n=n;
        this.cnt=cnt;
    }

    @Override
    public int compareTo(Point p){
        if(this.cnt==p.cnt) return this.n-p.n;
        return this.cnt-p.cnt;
    }
}
public class Main{
    static int r,c,k;
    static int rLen, cLen;
    static int[][] arr;
    public static void col(int key){
        PriorityQueue<Point> pQ = new PriorityQueue<>();
        Map<Integer,Integer> m = new HashMap<>();

        for(int i=0; i<rLen; i++){
            if(arr[i][key]==0)  continue;
            m.put(arr[i][key],m.getOrDefault(arr[i][key],0)+1);
        }
        m.forEach((k,v) -> pQ.offer(new Point(k,v)));

        int idx = 0;

        while(!pQ.isEmpty()){
            Point p = pQ.poll();
            arr[idx++][key]=p.n;
            arr[idx++][key]=p.cnt;
        }
        rLen =Math.max(rLen,idx);
        while(idx<=99){
            arr[idx++][key]=0;
        }
    }
    public static void row(int key){
        PriorityQueue<Point> pQ = new PriorityQueue<>();
        Map<Integer,Integer> m = new HashMap<>();

        for(int i=0; i<cLen; i++){
            if(arr[key][i]==0)  continue;
            m.put(arr[key][i],m.getOrDefault(arr[key][i],0)+1);
        }
        m.forEach((k,v) -> pQ.offer(new Point(k,v)));

        int idx = 0;

        while(!pQ.isEmpty()){
            Point p = pQ.poll();
            arr[key][idx++]=p.n;
            arr[key][idx++]=p.cnt;
        }

        cLen =Math.max(cLen,idx);

        while(idx<=99){
            arr[key][idx++]=0;
        }

    }

    public static void sorting(){
        if(rLen>=cLen){
            for(int i=0; i<rLen; i++){
                row(i);
            }
        }
        else{
            for(int i=0; i<cLen; i++){
                col(i);
            }
        }
    }
    public static int solution(){
        int time=0;

        while(time<=100){

            if(arr[r-1][c-1]==k)    return time;
            sorting();

            time++;
        }



        return -1;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        rLen =3;
        cLen =3;

        arr=new int[100][100];

        for(int i=0; i<3; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<3 ;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(solution());


    }
}