import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point{
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int M,N,L;
    static int[] mx;
    static Point[] animals;
    public static int solution(){
        int result = 0;

        Arrays.sort(mx);
        for(int i=0; i< animals.length; i++){
            result+=search(i);
        }
        return result;
    }

    public static int search(int index){
        int start = 0;
        int end = M;
        int mid;

        while(start <= end){
            mid = (start + end) / 2;
            //더이상 없는 경우
            if(mid>=M)  return 0;

            int distance = calculate(mx[mid], animals[index]);

            //사정거리 오른쪽 일 경우
            if(L < distance && animals[index].x < mx[mid]) end = mid - 1;
            //사정거리 왼쪽 일 경우
            else if(L < distance && animals[index].x >= mx[mid]) start = mid + 1;

            //사정거리 안에 있을 경우
            else if(L>=distance)    return 1;
        }

        //동물 근처에 잡을 수 있는 사대가 존재하지 않을 경우
        return 0;
    }

    public static int calculate(int cx, Point animal){
        return Math.abs(cx - animal.x) + animal.y;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        //사대
        mx = new int[M];
        animals = new Point[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)  mx[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            animals[i] = new Point(a,b);
        }

        System.out.println(solution());
    }
}
