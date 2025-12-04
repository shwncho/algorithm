class Solution {
    private int[] dx = {-1,0,1,0};
    private int[] dy = {0,1,0,-1};
    private boolean DFS(char[][] board, String word, int L, boolean[][] visited,
                        int x, int y) {
        if(L==word.length()) return true;

        if(x<0 || x>=board.length || y<0 || y>=board[0].length || visited[x][y] || word.charAt(L)!=board[x][y]) return false;

        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(DFS(board,word,L+1,visited,nx,ny))  return true;
        }

        visited[x][y] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)){
                    if(DFS(board,word,0,new boolean[m][n],i,j)) return true;
                }
            }
        }

        return false;
    }
}