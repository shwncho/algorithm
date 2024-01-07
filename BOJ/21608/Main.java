import java.util.*;
import java.io.*;
class Point{
    public int x,y,cnt;
    Point(int x , int y, int cnt){
        this.x=x;
        this.y=y;
        this.cnt = cnt;
    }
}
public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> orders = new ArrayList<>();

        int[][] table = new int[N*N+1][4];

        int[][] map = new int[N+1][N+1];

        for(int i=0; i<N*N; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            orders.add(num);

            table[num][0]=Integer.parseInt(st.nextToken());
            table[num][1]=Integer.parseInt(st.nextToken());
            table[num][2]=Integer.parseInt(st.nextToken());
            table[num][3]=Integer.parseInt(st.nextToken());
        }

        for(int num : orders){

            //비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸의 자리
            int max = 0;
            ArrayList<Point> numbers = new ArrayList<>();
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(map[i][j]==0){
                        int cnt = 0;
                        for(int k=0; k<4; k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];

                            if(0<nx && nx<=N && 0<ny && ny<=N){
                                if(map[nx][ny]==table[num][0] || map[nx][ny]==table[num][1] || map[nx][ny]==table[num][2]
                                        || map[nx][ny]==table[num][3])  cnt++;
                            }
                        }
                        numbers.add(new Point(i,j,cnt));
                        max=Math.max(max,cnt);
                    }

                }
            }

            List<Point> points = new ArrayList<>();

            for(Point p : numbers){
                if(max == p.cnt){
                    points.add(p);
                }
            }


            // 1번 조건으로 끝나면

            if(points.size()==1){
                Point p = points.get(0);
                map[p.x][p.y]=num;
            }

            // 2번 조건으로 넘어가기
            else{

                max = 0;
                numbers = new ArrayList<>();
                for(Point p : points){
                    int cnt = 0 ;
                    for(int i=0; i<4; i++) {
                        int nx = p.x + dx[i];
                        int ny = p.y + dy[i];

                        if (0 < nx && nx <= N && 0 < ny && ny <= N) {
                            if (map[nx][ny] == 0) cnt++;
                        }
                    }
                    max = Math.max(max,cnt);
                    numbers.add(new Point(p.x,p.y,cnt));
                }

                List<Point> zeroList = new ArrayList<>();

                for(Point p : numbers){
                    if(max == p.cnt){
                        zeroList.add(new Point(p.x,p.y,max));
                    }
                }

                // 2번 조건으로 끝나면
                if(zeroList.size()==1){
                    Point p = zeroList.get(0);
                    map[p.x][p.y]=num;
                }

                // 3번 조건
                else{

                    List<Point> last = new ArrayList<>();

                    int small = Integer.MAX_VALUE;
                    for(Point p : zeroList){
                        small = Math.min(small, p.x);
                    }

                    for(Point p : zeroList){
                        if(p.x==small){
                            last.add(new Point(p.x,p.y,0));
                        }
                    }

                    if(last.size()==1){
                        Point p = last.get(0);
                        map[p.x][p.y]=num;
                    }

                    else{
                        int sC = Integer.MAX_VALUE;
                        for(Point p : last){
                            sC = Math.min(sC,p.y);
                        }

                        map[small][sC]=num;
                    }
                }

            }

        }

        System.out.println(calculate(table, map, N));
    }

    private static int calculate(int[][] table, int[][] map, int N){
        int sum = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                int cnt = 0;
                for(int k=0; k<4; k++){
                    int nx =  i + dx[k];
                    int ny = j + dy[k];

                    if(0< nx && nx<=N && 0<ny && ny<=N){
                        int target = map[i][j];
                        if(map[nx][ny]==table[target][0] || map[nx][ny]==table[target][1]
                        || map[nx][ny]==table[target][2] || map[nx][ny]==table[target][3])  cnt++;
                    }

                }
                if(cnt!=0){
                    sum+=Math.pow(10,cnt-1);
                }

            }
        }

        return sum;
    }
}
