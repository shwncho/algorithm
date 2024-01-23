import java.util.*;
class Solution {

    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static Point endR,endB;
    static int result = Integer.MAX_VALUE;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static boolean[][] vRed, vBlue;
    public int solution(int[][] maze) {
        // 도착 칸에 도착하면 움직이지 않는다
        // 동시에 수레를 같은 칸으로 움직일 수 없다.
        // 퍼즐을 푸는데 필요한 턴의 최솟값을 구해라
        // 한 번 움직일 때마다 16가지 경우의 수, 4x4 격자 칸이므로 최대 16^2 경우의 수
        // 둘 다 각자 움직일 수 있는지 확인하는 메서드 필요. 단, 도착지일 경우 안움직여도된다.
        Point red = new Point(0,0);
        Point blue = new Point(0,0);
        n = maze.length;
        m = maze[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maze[i][j]==1){
                    red = new Point(i,j);
                }
                else if(maze[i][j]==2){
                    blue = new Point(i,j);
                }
                else if(maze[i][j]==3){
                    endR = new Point(i,j);
                }
                else if(maze[i][j]==4){
                    endB = new Point(i,j);
                }
            }
        }
        vRed = new boolean[n][m];
        vRed[red.x][red.y] = true;
        vBlue = new boolean[n][m];
        vBlue[blue.x][blue.y] = true;


        DFS(maze, red, blue, 0);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private void DFS(int[][] maze, Point red,
                     Point blue, int cnt){
        //최소움직임
        if(red.x == endR.x && red.y == endR.y
                && blue.x == endB.x && blue.y == endB.y){
            result = Math.min(result, cnt);
            return;
        }

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                Point nRed = (red.x == endR.x && red.y == endR.y) ? red
                        : new Point(red.x+dx[i],red.y+dy[i]);
                Point nBlue = (blue.x == endB.x && blue.y == endB.y) ? blue
                        : new Point(blue.x+dx[j],blue.y+dy[j]);

                if(move(maze,red,blue,nRed,nBlue)){

                    vRed[nRed.x][nRed.y]=true;
                    vBlue[nBlue.x][nBlue.y]=true;
                    DFS(maze,nRed,nBlue,cnt+1);
                    vRed[nRed.x][nRed.y]=false;
                    vBlue[nBlue.x][nBlue.y]=false;
                }
            }
        }

    }

    private boolean move(int[][] maze, Point red, Point blue,
                         Point nRed, Point nBlue){

        //범위 및 벽돌 체크
        if(nRed.x<0 || nRed.x>=n || nRed.y<0 || nRed.y>=m ||
                maze[nRed.x][nRed.y]==5)
            return false;

        if(nBlue.x<0 || nBlue.x>=n || nBlue.y<0 || nBlue.y>=m ||
                maze[nBlue.x][nBlue.y]==5)
            return false;

        //도착지점이 아닌곳에서 중복방문일 경우
        //-> 도착지점에 이미 도착한 경우는 움직이지않아도 되므로 중복 허용
        if((nRed.x!=endR.x || nRed.y!=endR.y) && vRed[nRed.x][nRed.y])
            return false;

        if((nBlue.x!=endB.x || nBlue.y!=endB.y) && vBlue[nBlue.x][nBlue.y])
            return false;

        //수레들이 서로 스위치 하는 경우
        if(red.x == nBlue.x && red.y == nBlue.y && blue.x == nRed.x &&
                blue.y == nRed.y) return false;

        //동일 칸 위치 금지
        if(nRed.x == nBlue.x && nRed.y == nBlue.y)    return false;

        return true;
    }
}