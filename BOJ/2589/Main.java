import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = 0;
    static class Point{
        int x,y,dis;
        Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0; i<N; i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = chars[j];
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 'L'){
                    visited = new boolean[N][M];
                    BFS(i,j);
                }
            }
        }

        System.out.println(answer);


    }
    private static void BFS(int x, int y){
        visited[x][y]=true;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y,0));
        while(!q.isEmpty()){

            Point now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M)  continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny]!='L')    continue;

                visited[nx][ny]=true;
                q.offer(new Point(nx,ny,now.dis+1));
                answer = Math.max(answer, now.dis+1);
            }
        }
    }
}
