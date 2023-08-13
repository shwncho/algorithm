import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x,y,prev,sum;
    Point(int x, int y, int prev, int sum){
        this.x = x;
        this.y = y;
        this.prev = prev;
        this.sum = sum;
    }
}
public class Main {
    static int n,m;
    static int[] dy={-1,0,1};
    static int[][] graph;
    static int answer = Integer.MAX_VALUE;
    static public void BFS(){
        Queue<Point> Q = new LinkedList<>();

        for(int i=0; i<m; i++){
            Q.offer(new Point(0,i,2,graph[0][i]));
        }

        while(!Q.isEmpty()){
            int len = Q.size();

            for(int i=0; i<len; i++){
                Point tmp = Q.poll();

                if(tmp.x == n-1){
                    answer=Math.min(answer, tmp.sum);
                    continue;
                }

                // prev -1 은 왼쪽 아래, 0은 아래, 1은 오른쪽 아래
                for(int j=0; j<3; j++){
                    int nx = tmp.x + 1;
                    int ny = tmp.y + dy[j];

                    if(tmp.prev == dy[j] || ny < 0 || ny >= m || nx >= n) continue;

                    Q.offer(new Point(nx, ny, dy[j], tmp.sum + graph[nx][ny]));
                }
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();
        System.out.println(answer);

    }
}
