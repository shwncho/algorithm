import java.io.*;
import java.util.*;
public class Main {
    private static char[][] map;
    private static int n,m;
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    private static boolean[][][][][] visited;
    private static class Point{
        private final int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static class Node{
        private final int x,y,cnt,dir;
        private final int visited1,visited2;
        Node(int x, int y, int cnt, int dir,
             int visited1, int visited2){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
            this.visited1 = visited1;
            this.visited2 = visited2;
        }


    }
    private static List<Point> dest = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m][4][2][2];
        int startX=0;
        int startY=0;
        map = new char[n][m];
        for(int i=0; i<n; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j=0; j<ch.length; j++){
                map[i][j] = ch[j];
                if(ch[j]=='S'){
                    startX = i;
                    startY = j;
                }
                if(ch[j]=='C')  dest.add(new Point(i,j));
            }
        }

        System.out.println(BFS(startX,startY,0,-1,0,0));

    }
    private static int BFS(int x, int y, int cnt, int direction, int visited1, int visited2){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(new Node(x,y,cnt,direction,visited1,visited2));

        while(!Q.isEmpty()){
            Node tmp = Q.poll();
            if(tmp.visited1==1&& tmp.visited2==1){
                return tmp.cnt;
            }

            for(int i=0; i<4; i++){
                if(tmp.dir==i) continue;

                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                int nVisited1 = tmp.visited1;
                int nVisited2 = tmp.visited2;

                if(nx<0 || nx>=n || ny<0 || ny>=m)  continue;
                if(map[nx][ny]=='#')    continue;
                if(visited[nx][ny][i][nVisited1][nVisited2])  continue;

                if(nx==dest.get(0).x && ny==dest.get(0).y)    nVisited1=1;
                if(nx==dest.get(1).x && ny==dest.get(1).y)   nVisited2=1;


                visited[nx][ny][i][nVisited1][nVisited2] = true;
                Q.offer(new Node(nx,ny, tmp.cnt+1, i, nVisited1, nVisited2));


            }

        }


        return -1;

    }
}
