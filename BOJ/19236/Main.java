import java.io.*;
import java.util.*;
class Fish{
    public int x,y;
    public int number, direction;
    public boolean life;
    Fish(int x, int y, int number, int direction,boolean life){
        this.x = x;
        this.y = y;
        this.number = number;
        this.direction = direction;
        this.life = life;
    }
}
public class Main {
    //2차원 그래프, 방향, 상어가 먹은 물고기 번호의 최댓값
    static int[][] graph;
    static Fish[] fishes;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        graph = new int[4][4];
        fishes = new Fish[17];

        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                int number = Integer.parseInt(st.nextToken());

                int direction = Integer.parseInt(st.nextToken());

                fishes[number] = new Fish(i,j,number,direction-1,true);

                graph[i][j]=number;
            }
        }

        int sd = fishes[graph[0][0]].direction;
        int number = fishes[graph[0][0]].number;
        fishes[graph[0][0]].life=false;
        graph[0][0]=-1;

        DFS(0,0,sd,number);


        System.out.println(answer);

    }

    private static void DFS(int sx, int sy, int sd, int sum){
        answer = Math.max(answer, sum);

        int[][] copyGraph = copyGraph(graph);
        Fish[] copyFishes = copyFishes(fishes);

        moveFishes();

        for(int i=1; i<4; i++){
            int nx = sx + dx[sd] * i;
            int ny = sy + dy[sd] * i;

            if(nx<0 || nx>=4 || ny<0 || ny>=4 || graph[nx][ny]==0)  continue;

            int eatFish = graph[nx][ny];
            int nextDirection = fishes[eatFish].direction;
            graph[sx][sy]=0;
            graph[nx][ny]=-1;
            fishes[eatFish].life=false;

            DFS(nx,ny,nextDirection,sum+eatFish);

            graph[sx][sy]=-1;
            graph[nx][ny]=eatFish;
            fishes[eatFish].life=true;
        }

        graph = copyGraph(copyGraph);
        fishes = copyFishes(copyFishes);


    }

    private static int[][] copyGraph(int[][] graph) {
        int[][] copyGraph = new int[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                copyGraph[i][j] = graph[i][j];
            }
        }
        return copyGraph;
    }

    private static Fish[] copyFishes(Fish[] fishes){
        Fish[] copyFishes = new Fish[17];
        for(int i=1; i<=16; i++){
            copyFishes[i] = new Fish(fishes[i].x, fishes[i].y, fishes[i].number, fishes[i].direction, fishes[i].life);
        }
        return copyFishes;
    }

    private static void moveFishes(){
        for(int i=1; i<=16; i++){
            if(!fishes[i].life)   continue;

            for(int j=0; j<8; j++){
                int nx = fishes[i].x + dx[fishes[i].direction];
                int ny = fishes[i].y + dy[fishes[i].direction];

                if(nx< 0 || nx>=4 || ny<0 || ny>=4 || graph[nx][ny]==-1){
                    fishes[i].direction = (fishes[i].direction+1)%8;
                }
                else{
                    if(graph[nx][ny]==0){
                        graph[fishes[i].x][fishes[i].y]=0;
                        fishes[i].x=nx;
                        fishes[i].y=ny;
                        graph[nx][ny]=i;
                    }
                    else{
                        int changeNum = fishes[graph[nx][ny]].number;
                        fishes[graph[nx][ny]].x = fishes[i].x;
                        fishes[graph[nx][ny]].y = fishes[i].y;
                        graph[fishes[graph[nx][ny]].x][fishes[graph[nx][ny]].y ] = changeNum;

                        fishes[i].x = nx;
                        fishes[i].y = ny;
                        graph[nx][ny]=i;
                    }
                    break;
                }
            }
        }
    }

}
