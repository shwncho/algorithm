import java.util.*;
class Solution {
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        char[][] map = new char[n][m];

        for(int i=0; i<n; i++)  map[i] = storage[i].toCharArray();

        for(String r : requests) {
            char target = r.charAt(0);

            // 크레인
            if(r.length()==2) {
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                        if(map[i][j] == target) map[i][j] = '.';
                    }
                }
            }
            // 지게차
            else {
                BFS(map,target,n,m);
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]!='.')  answer++;
            }
        }
        return answer;
    }

    private void BFS(char[][] map, char target, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n+2][m+2];

        char[][] board = new char[n+2][m+2];
        for(int i=0; i<n+2; i++)    Arrays.fill(board[i], '.');

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                board[i+1][j+1] = map[i][j];
            }
        }

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        q.offer(new int[]{0,0});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=n+2 || ny<0 || ny>=m+2)  continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if(board[nx][ny]=='.')    q.offer(new int[]{nx,ny});
                else if(board[nx][ny] == target) {
                    board[nx][ny] = '.';
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = board[i+1][j+1];
            }
        }
    }
}