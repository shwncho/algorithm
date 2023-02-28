import java.util.*;
import java.io.*;
class Point{
    public int x,y;

    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main{
    static int n,m;
    static char[][] graph;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Point> sList = new ArrayList<>();
    static boolean[][] visited;
    static boolean defence(){
        for(Point p : sList){

            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)    continue;

                if(graph[nx][ny]=='.')    graph[nx][ny]='D';
                else if(graph[nx][ny]=='W') return false;
            }
        }


        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j]=s.charAt(j);
                if(graph[i][j]=='S')    sList.add(new Point(i,j));
            }
        }


        StringBuilder sb = new StringBuilder();
        if(!defence()){
            System.out.println(0);
            System.exit(0);
        }

        sb.append(1).append("\n");

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}