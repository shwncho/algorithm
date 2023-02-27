import java.util.*;

class Point{
    public int x,y,cnt;
    Point(int x, int y,int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}
class Solution {
    static int[][] graph;
    static int answer=Integer.MAX_VALUE;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void BFS(Point start, Point end){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        q.offer(start);
        visited[start.x][start.y]=true;
        while(!q.isEmpty()){
            Point tmp = q.poll();

            if(tmp.x==end.x && tmp.y == end.y){
                answer=Math.min(answer,tmp.cnt);
            }
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];

                if(nx<0 || nx>100 || ny<0 || ny>100)  continue;

                if(graph[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new Point(nx,ny,tmp.cnt+1));
                }
            }
        }
    }
    public static void init(int x1, int x2, int y1, int y2){
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(graph[i][j]==2)  continue;

                if(i==x1 || i==x2 || j==y1 || j==y2){
                    graph[i][j]=1;
                }
                else    graph[i][j]=2;
            }
        }
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        //테두리를 올바르게 따라가게 하기 위해 좌표를 2배로 확장 
        graph=new int[101][101];
        //테두리는 1, 테두리 내부는 2 (0일 경우 다른 사각형이 테두리 표시할 수 있으므로 방지하기위해)
        for(int i=0; i<rectangle.length; i++){
            init(rectangle[i][0]*2,rectangle[i][2]*2, rectangle[i][1]*2,rectangle[i][3]*2);
        }

        Point start = new Point(characterX*2, characterY*2,0);
        Point end = new Point(itemX*2, itemY*2,0);

        BFS(start,end);

        return answer/2;
    }
}