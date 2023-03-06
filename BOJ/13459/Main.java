import java.util.*;
import java.io.*;

/**
 * 구슬 탈출 핵심
 * 1. 빨간 구슬과 파란 구슬의 겹치는 여부
 * 2. 빨간,파란 구슬 위치 동시 이동
 * 3. 기울여서 이동
 */
class Point{
    public int x,y;

    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main{
    static int n,m;
    static char[][] graph;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph= new char[n][m];

        Point red = null;
        Point blue = null;
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j]=s.charAt(j);
                if(graph[i][j]=='R')    red=new Point(i,j);
                else if(graph[i][j]=='B')   blue = new Point(i,j);
            }
        }

        for(int i=0; i<4; i++){
            DFS(red,blue,0,i);
        }
        System.out.println(answer);

    }

    public static void DFS(Point red, Point blue, int t, int d){
        if(t>=10)   return;

        int rx = red.x;
        int ry = red.y;
        int bx = blue.x;
        int by = blue.y;
        boolean flag= false;

        //빨간 구슬, 파란 구슬 기울이기
        while(rx>=0 && rx<n && ry>=0 && ry<m){
            rx+=dx[d];
            ry+=dy[d];

            if(graph[rx][ry]=='O'){
                flag=true;
                break;
            }

            if(graph[rx][ry]=='#'){
                rx-=dx[d];
                ry-=dy[d];
                break;
            }
        }

        while(bx>=0 && bx<n && by>=0 && by<m){
            bx+=dx[d];
            by+=dy[d];

            if(graph[bx][by]=='O') return;

            if(graph[bx][by]=='#'){
                bx-=dx[d];
                by-=dy[d];
                break;
            }
        }
        // 빨간 구슬만 홀에 들어갔으면 종료
        if(flag){
            answer=1;
            return;
        }
        //겹칠 경우 처리
        if(rx==bx && ry==by){
            if(d==0 && blue.x < red.x){
                rx++;
            }
            else if(d==0 && blue.x > red.x){
                bx++;
            }
            else if(d==1 && blue.y < red.y){
                by--;
            }
            else if(d==1 && blue.y > red.y){
                ry--;
            }
            else if(d==2 && blue.x < red.x){
                bx--;
            }
            else if(d==2 && blue.x > red.x){
                rx--;
            }
            else if(d==3 && blue.y < red.y){
                ry++;
            }
            else if(d==3 && blue.y > red.y){
                by++;
            }
        }

        for(int i=0; i<4; i++){
            DFS(new Point(rx,ry), new Point(bx,by),t+1,i);
        }
    }
}