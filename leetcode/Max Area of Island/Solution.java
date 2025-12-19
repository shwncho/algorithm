class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int answer = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1){
                    answer = Math.max(answer, BFS(grid,i,j,m,n));
                }

            }
        }

        return answer;
    }

    private int BFS(int[][] grid, int x, int y,int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        int result = 0;

        grid[x][y]=0;
        result++;
        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n)  continue;

                if(grid[nx][ny]==0) continue;

                result++;
                grid[nx][ny]=0;
                q.offer(new int[]{nx,ny});
            }
        }


        return result;
    }
}