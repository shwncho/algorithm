import java.util.*;
class Point{
    public int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;

        int n = maps.length;
        int m = maps[0].length;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        int[][] graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] dis = new int[n][m];

        for(int i=0; i<n; i++){
            graph[i]=maps[i].clone();
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0));
        visited[0][0]=true;
        dis[0][0]=1;
        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)  continue;

                if(visited[nx][ny] || graph[nx][ny]==0) continue;

                visited[nx][ny]=true;
                q.offer(new Point(nx,ny));
                dis[nx][ny]=dis[p.x][p.y]+1;

            }
        }

        answer = dis[n-1][m-1] !=0 ? dis[n-1][m-1] : -1;
        return answer;
    }
}