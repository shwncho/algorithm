class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    private void DFS(int x, int y, int m, int n, char[][] grid,boolean[][] visited){
        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
            if(visited[nx][ny] || grid[nx][ny]=='0')    continue;

            visited[nx][ny] = true;
            DFS(nx,ny,m,n,grid,visited);
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int answer = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    answer++;
                    visited[i][j]=true;
                    DFS(i,j,m,n,grid,visited);
                }
            }
        }

        return answer;
    }
}