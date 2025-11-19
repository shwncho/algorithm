class Solution {
    private class Point {
        int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            if(board[i][0]=='O')     BFS(board,i,0);
            if(board[i][n-1]=='O')  BFS(board,i,n-1);
        }

        for(int j=0; j<n; j++) {
            if(board[0][j]=='O')    BFS(board,0,j);
            if(board[m-1][j]=='O')  BFS(board,m-1,j);
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'O')  board[i][j] = 'X';
                if(board[i][j] == '#')  board[i][j] = 'O';
            }
        }

    }
    private void BFS(char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        board[x][y]='#';
        while(!q.isEmpty()) {
            Point now = q.poll();

            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n)  continue;

                if(board[nx][ny]=='O'){
                    board[nx][ny]='#';
                    q.offer(new Point(nx,ny));
                }
            }
        }
    }
}