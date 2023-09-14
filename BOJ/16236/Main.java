import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x,y,distance;
    Point(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
public class Main {
    static int babySharkSize=2;
    static int babySharkEatingNum=0;
    static int[][] graph;
    static int n;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static Queue<Point> Q = new LinkedList<>();
    static int time=0;


    static Point findMinDistanceFish(ArrayList<Point> fishes){
        Point target = fishes.get(0);
        for(int i=1; i<fishes.size(); i++){
            if(target.distance > fishes.get(i).distance){
                target = fishes.get(i);
            }
            else if(target.distance == fishes.get(i).distance){
                if(fishes.get(i).x < target.x)  target= fishes.get(i);
                else if(fishes.get(i).x == target.x){
                    if(fishes.get(i).y < target.y)  target = fishes.get(i);
                }
            }
        }

        return target;

    }

    static Point calculateDistance(){
        //물고기는 잡아 먹히면 사라지므로 메서드 실행마다 초기화 되는 것이 좋으므로 -> 지역변수로 사용
        ArrayList<Point> fishes = new ArrayList<>();
        int[][] distance = new int[n][n];

        while(!Q.isEmpty()){
            Point p = Q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)  continue;

                //distance에 값이 있으면 이미 지나간 곳
                if(distance[nx][ny]!=0 || graph[nx][ny]>babySharkSize)  continue;

                distance[nx][ny] = distance[p.x][p.y]+1;
                Q.offer(new Point(nx,ny, distance[nx][ny]));
                if(1<=graph[nx][ny] && graph[nx][ny]<=6 && graph[nx][ny] < babySharkSize){
                    fishes.add(new Point(nx,ny,distance[nx][ny]));
                }
            }
        }

        if(fishes.size() == 0){
            System.out.println(time);
            System.exit(0);
        }

        Point target = findMinDistanceFish(fishes);

        time += target.distance;
        babySharkEatingNum++;
        graph[target.x][target.y]=0;

        if(babySharkSize == babySharkEatingNum){
            babySharkSize++;
            babySharkEatingNum=0;
        }

        return target;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 9){
                    Q.offer(new Point(i,j,0));
                    graph[i][j]=0;
                }
            }
        }

        while(true){
            Point currentPosition = calculateDistance();
            Q.offer(new Point(currentPosition.x, currentPosition.y, 0));
        }





    }
}
