import java.io.*;
import java.util.*;

class Point{
    public int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    static char[][] graph;
    static int r, c;
    static boolean[][] visited;
    static int[]dx= {-1,0,1,0};
    static int[]dy= {0,1,0,-1};
    static Queue<Point>cluster=new LinkedList<>();;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        r =Integer.parseInt(st.nextToken());
        c =Integer.parseInt(st.nextToken());

        graph =new char[r][c];
        for(int i = 0; i< r; i++) graph[i]=br.readLine().toCharArray();

        int cnt=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());

        for(int t=0;t<cnt;t++){
            int height= r -Integer.parseInt(st.nextToken());
            //부수기
            remove(t%2,height);
            visited =new boolean[r][c];

            //바닥으로부터 떨어지는 클러스터 BFS탐색
            for(int i = 0; i< c; i++) {
                if(graph[r -1][i]=='x'&&!visited[r -1][i])
                    BFS(r -1,i);
            }

            boolean downCheck=false;
            for(int i = 0; i< r; i++) {
                //떨어지는 클러스터는 1개임이 보장
                if(downCheck)   break;
                for(int j = 0; j< c; j++) {
                    if(graph[i][j]=='x'&&!visited[i][j]) {
                        BFS(i,j);
                        down();
                        //떨어졌으므로 true표시한 뒤 반복중지
                        downCheck=true;
                        break;
                    }
                }
            }
        }
        for(char[] a: graph) {
            for(char c: a) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void remove(int d,int height) {
        int i=0;
        // 왼쪽
        if(d==0) {
            for(i=0; i< c; i++) {
                if(graph[height][i]=='x') {
                    graph[height][i]='.';
                    break;
                }
            }
        }
        // 오른쪽
        else {
            for(i= c -1; i>=0; i--) {
                if(graph[height][i]=='x') {
                    graph[height][i]='.';
                    break;
                }
            }
        }
    }
    //클러스터 찾기
    static void BFS(int x, int y) {
        Queue<Point> Q=new LinkedList<>();
        cluster.clear();
        cluster.add(new Point(x,y));
        Q.add(new Point(x,y));
        visited[x][y]=true;
        while(!Q.isEmpty()) {
            Point tmp=Q.poll();
            for(int i=0;i<4;i++) {
                int nx= tmp.x + dx[i];
                int ny= tmp.y + dy[i];
                if(nx>=0&&ny>=0&&nx< r &&ny< c &&!visited[nx][ny]&& graph[nx][ny]=='x') {
                    visited[nx][ny]=true;
                    cluster.add(new Point(nx,ny));
                    Q.add(new Point(nx,ny));
                }
            }
        }
    }
    //분리되어 있는 클러스터를 아래로 이동
    static void down() {
        Point[] tmp=new Point[cluster.size()];
        int i=0, dx=0,size=tmp.length;
        while(!cluster.isEmpty()) {
            tmp[i++] = cluster.poll();
        }
        change(0, size, tmp, '.');
        while(true) {
            if(check(dx+1, size, tmp))   dx++;
            else break;
        }
        change(dx, size, tmp, 'x');
    }
    //graph 상태 변경
    static void change(int dx,int size, Point[] tmp,char c) {
        for(int i=0;i<size;i++) {
            int nx = tmp[i].x+dx;
            int ny = tmp[i].y;
            graph[nx][ny]=c;
        }
    }
    //내려갈 수 있는지 확인
    static boolean check(int dx,int size, Point[] tmp) {
        for(int i=0;i<size;i++) {
            int nx = tmp[i].x+dx;
            int ny = tmp[i].y;
            if(nx>= r || graph[nx][ny]=='x') return false;
        }
        return true;
    }
}