class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Point {
        int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Point> Q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    grid[i][j]=-1;
                    Q.offer(new Point(i,j));
                }
            }
        }

        int[][] map = new int[n][m];

        while(!Q.isEmpty()) {
            Point now = Q.poll();
            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m)  continue;
                if(grid[nx][ny]==1){
                    map[nx][ny] = map[now.x][now.y] + 1;
                    grid[nx][ny]=-1;
                    Q.offer(new Point(nx,ny));
                }
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1)   return -1;
                answer = Math.max(answer, map[i][j]);
            }
        }

        return answer;
    }
}