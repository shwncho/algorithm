import java.io.*;
import java.util.*;
public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};

        int[][] dis = new int[N][N];
        char[][] map = new char[N][N];
        for(int i=0; i<N; i++)  map[i] = br.readLine().toCharArray();
        for(int i=0; i<N; i++)  Arrays.fill(dis[i], Integer.MAX_VALUE);

        Deque<Point> dq = new ArrayDeque<>();
        dq.offerFirst(new Point(0,0));
        dis[0][0] = 0;

        while(!dq.isEmpty()) {
            Point cur = dq.pollFirst();

            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                int cost = (map[nx][ny] == '0') ? 1 : 0;
                int nextDist = dis[cur.x][cur.y] + cost;

                if(dis[nx][ny] > nextDist) {
                    dis[nx][ny] = nextDist;

                    if(cost == 0)   dq.offerFirst(new Point(nx,ny));
                    else    dq.offerLast(new Point(nx,ny));
                }
            }
        }

        System.out.println(dis[N-1][N-1]);
    }
}
