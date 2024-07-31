import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Point{
        int x,y,d;
        Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static int N;
    static int[][] map;
    static Map<Integer,String> directionChanges = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for(int i = 0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            directionChanges.put(s,direction);

        }

        System.out.println(BFS());



    }

    private static int BFS(){
        Deque<Point> snake = new LinkedList<>();
        snake.add(new Point(1,1,1));

        //뱀 표시
        map[1][1] = 2;


        int time = 0;

        while(!snake.isEmpty()){
            time++;
            //머리 추출, 덱에서 제거하지않은채 리턴
            Point now = snake.getLast();

            int nx = now.x + dx[now.d];
            int ny = now.y + dy[now.d];

            //벽 체크
            if(1<=nx && nx<=N && 1<=ny && ny<=N){
                //본인 몸일 경우
                if(map[nx][ny]==2)  break;
                else{
                    //사과여부
                    //사과있으면 꼬리 삭제 안하고, 없으면 꼬리 삭제 해야함
                    if(map[nx][ny]==0){
                        Point tail = snake.pollFirst();
                        map[tail.x][tail.y]=0;
                    }
                }
            }
            //벽에 부딪힘
            else break;

            if(directionChanges.containsKey(time)){
                String C = directionChanges.get(time);
                if(C.equals("D")){
                    snake.addLast(new Point(nx,ny,(now.d+1)%4));
                }
                else{
                    if(now.d==0)    snake.addLast(new Point(nx,ny,3));
                    else snake.addLast(new Point(nx,ny, now.d-1));
                }
            }
            else{
                snake.addLast(new Point(nx,ny,now.d));
            }

            map[nx][ny]=2;

        }


        return time;
    }
}
