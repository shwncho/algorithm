import java.util.*;
import java.io.*;

class Point{
    public int[] red;
    public int[] blue;

    Point(int[] red, int[] blue){
        this.red=red;
        this.blue=blue;
    }
}
public class Main{
    static int n,m;
    static char[][] graph;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph= new char[n][m];
        int[] red = new int[2];
        int[] blue = new int[2];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j]=s.charAt(j);
                if(graph[i][j]=='R'){
                    red[0]=i;
                    red[1]=j;
                }
                else if(graph[i][j]=='B'){
                    blue[0]=i;
                    blue[1]=j;
                }
            }
        }

        System.out.println(BFS(new Point(red,blue)));

    }

    public static int BFS(Point p){
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        boolean[][][][] visited = new boolean[n][m][n][m];
        visited[p.red[0]][p.red[1]][p.blue[0]][p.blue[1]]=true;

        int t=0;

        while(!q.isEmpty() && t<10){
            int len = q.size();

            for(int i=0; i<len; i++){
                Point tmp = q.poll();

                for(int j=0; j<4; j++){
                    int[] nRed = tmp.red.clone();
                    int[] nBlue = tmp.blue.clone();

                    if(move(nRed,nBlue,j)){
                        if(graph[nRed[0]][nRed[1]]=='O') return t+1;

                        if(visited[nRed[0]][nRed[1]][nBlue[0]][nBlue[1]])   continue;

                        visited[nRed[0]][nRed[1]][nBlue[0]][nBlue[1]]=true;

                        q.offer(new Point(nRed,nBlue));
                    }
                }
            }
            t++;
        }
        return -1;
    }

    public static boolean move(int[] red, int[] blue, int d){
        boolean redFirst = false;
        if(d==0 && red[0]>blue[0])  redFirst=true;
        else if(d==1 && red[1]<blue[1]) redFirst=true;
        else if(d==2 && red[0]<blue[0]) redFirst=true;
        else if(d==3 && red[1]>blue[1]) redFirst=true;

        int nx = red[0];
        int ny = red[1];
        while(true){
            nx+=dx[d];
            ny+=dy[d];

            if(graph[nx][ny]=='#')  break;
            red[0]=nx;
            red[1]=ny;
            if(graph[nx][ny]=='O')  break;
        }

        nx = blue[0];
        ny = blue[1];
        while(true){
            nx+=dx[d];
            ny+=dy[d];

            if(graph[nx][ny]=='#')  break;
            blue[0]=nx;
            blue[1]=ny;
            if(graph[nx][ny]=='O')  break;
        }

        if(graph[blue[0]][blue[1]]=='O')    return false;

        if(red[0]==blue[0] && red[1]==blue[1]){
            switch(d){
                case 0:
                    if(redFirst)  red[0]++;
                    else blue[0]++;
                    break;
                case 1:
                    if(redFirst)    red[1]--;
                    else blue[1]--;
                    break;
                case 2:
                    if(redFirst)    red[0]--;
                    else blue[0]--;
                    break;
                case 3:
                    if(redFirst)    red[1]++;
                    else blue[1]++;
                    break;
            }
        }

        return true;
    }
}