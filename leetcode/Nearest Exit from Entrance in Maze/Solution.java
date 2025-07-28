class Solution {
    private class Point{
        int x,y,cnt;
        Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        int m = maze.length;
        int n = maze[0].length;

        maze[entrance[0]][entrance[1]] = '+';
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(entrance[0],entrance[1],0));
        while(!q.isEmpty()){
            Point tmp = q.poll();
            if(!(tmp.x == entrance[0] && tmp.y == entrance[1])&&
                    (tmp.x == 0 || tmp.x == m-1 || tmp.y == 0 || tmp.y == n-1))
            {
                return tmp.cnt;
            }

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n || maze[nx][ny]=='+')   continue;

                maze[nx][ny]='+';
                q.offer(new Point(nx,ny,tmp.cnt+1));
            }
        }


        return -1;
    }
}