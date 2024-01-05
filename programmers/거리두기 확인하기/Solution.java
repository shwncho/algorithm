import java.util.*;
class Point{
    public int x,y,cnt;
    Point(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt =cnt;
    }
}

class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    public int[] solution(String[][] places) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<5; i++){
            char[][] graph = new char[5][5];
            for(int j=0; j<5; j++){
                graph[j] = places[i][j].toCharArray();
            }
            result.add(solve(graph));
        }

        answer = result.stream().mapToInt(integer -> integer).toArray();
        return answer;
    }

    private static int solve(char[][] graph){
        ArrayList<Point> points = new ArrayList<>();
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(graph[i][j]=='P')    points.add(new Point(i,j,0));
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        for(Point p : points){
            visited = new boolean[5][5];
            if(!BFS(p.x,p.y,graph))   return 0;
        }

        return 1;
    }

    private static boolean BFS(int x, int y,char[][] graph){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y,0));
        visited[x][y]=true;

        while(!Q.isEmpty()){

            Point p = Q.poll();

            if(p.cnt==2)  continue;

            for(int i=0; i<4 ;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || nx>=5 || ny<0 || ny>=5)  continue;

                if(graph[nx][ny]=='X')   continue;

                if(visited[nx][ny]) continue;

                if(graph[nx][ny]=='P')  return false;

                visited[nx][ny]=true;
                Q.offer(new Point(nx,ny,p.cnt+1));
            }
        }

        return true;


    }
}