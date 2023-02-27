import java.util.*;
import java.io.*;
class Point{
    public int x,y;
    public char c;
    Point(int x, int y, char c){
        this.x=x;
        this.y=y;
        this.c=c;
    }
}
public class Main{
    static char[][] graph = new char[12][6];
    static int answer=0;
    static boolean flag;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void BFS(){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];

        for(int i=0; i<12; i++){
            for(int j=0; j<6; j++){
                if(graph[i][j]!='.' && !visited[i][j]){
                    ArrayList<Point> list = new ArrayList<>();

                    q.offer(new Point(i,j,graph[i][j]));
                    list.add(new Point(i,j,graph[i][j]));
                    visited[i][j]=true;

                    while(!q.isEmpty()){
                        Point p = q.poll();

                        for(int k=0; k<4 ;k++){
                            int nx = p.x+dx[k];
                            int ny = p.y+dy[k];

                            if(nx<0 || nx>=12 || ny<0 || ny>=6)    continue;

                            if(!visited[nx][ny] && graph[nx][ny]==p.c){
                                q.offer(new Point(nx,ny,p.c));
                                list.add(new Point(nx,ny,p.c));
                                visited[nx][ny]=true;
                            }
                        }
                    }

                    if(list.size()>=4){
                        for(Point p : list){
                            graph[p.x][p.y]='.';
                            flag=true;
                        }
                    }
                }
            }
        }
    }

    public static void move(){
        for(int i=0; i<6; i++){
            down(i);
        }
    }

    public static void down(int col){
        Queue<Point> q = new LinkedList<>();

        for(int i=11; i>=0; i--){
            if(graph[i][col]!='.'){
                q.offer(new Point(i,col,graph[i][col]));
                graph[i][col]='.';
            }
        }
        int idx=11;
        while(!q.isEmpty()){
            Point p = q.poll();

            graph[idx][col]=p.c;
            idx--;
        }


    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<12; i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<6; j++){
                graph[i][j]=chars[j];
            }
        }

        while(true){
            flag=false;

            BFS();
            move();

            if(!flag)   break;

            answer++;

        }


        System.out.println(answer);
    }
}