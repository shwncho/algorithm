class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];

        for(int i=0; i<m; i++)  Arrays.fill(dist[i], Integer.MAX_VALUE);

        Queue<Node> q = new LinkedList<>();

        dist[0][0] = 0;
        q.offer(new Node(0,0));
        while(!q.isEmpty()) {
            Node now = q.poll();

            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n)  continue;

                int newDist = dist[now.x][now.y] + grid[nx][ny];
                if(newDist < dist[nx][ny]) {
                    dist[nx][ny] = newDist;
                    q.offer(new Node(nx,ny));
                }
            }
        }


        return dist[m-1][n-1];
    }
}