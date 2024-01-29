import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static int N;
    static int answer=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int value = Integer.parseInt(st.nextToken());
                map[i][j]=value;
            }
        }
        DFS(0,1,0);
        System.out.println(answer);

    }

    private static void DFS(int x, int y, int shape){
        if(x==N-1 && y==N-1){
            answer++;
            return;
        }

        //가로
        if(shape==0){
            //가로방향이동
            if(y+1<N && map[x][y+1]!=1)   DFS(x,y+1,0);
            //대각선이동
            if(x+1<N && y+1<N && map[x][y+1]!=1 && map[x+1][y]!=1 && map[x+1][y+1]!=1)  DFS(x+1,y+1,2);
        }
        //세로
        else if(shape==1){
            //세로이동
            if(x+1<N && map[x+1][y]!=1)   DFS(x+1,y,1);
            //대각선이동
            if(x+1<N && y+1<N && map[x][y+1]!=1 && map[x+1][y]!=1  && map[x+1][y+1]!=1)  DFS(x+1,y+1,2);
        }
        //대각선
        else{
            //가로방향이동
            if(y+1<N && map[x][y+1]!=1)   DFS(x,y+1,0);
            //세로이동
            if(x+1<N && map[x+1][y]!=1)   DFS(x+1,y,1);
            //대각선이동
            if(x+1<N && y+1<N && map[x][y+1]!=1 && map[x+1][y]!=1  && map[x+1][y+1]!=1)  DFS(x+1,y+1,2);
        }
    }
}
