import java.util.*;
import java.io.*;

public class Main{
    static int n,m,k;
    static int answer=Integer.MIN_VALUE;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void DFS(int x, int y, int cnt, int sum){
        if(cnt==k)    answer=Math.max(answer,sum);
        else{
            //파라미터로 들어온  x,y 부터 탐색하도록 설정
            for(int i=x; i<n; i++){
                for(int j=y; j<m; j++){
                    if(!visited[i][j]){
                        if(check(i,j)){
                            visited[i][j]=true;
                            //cnt와 sum을 전역변수로 설정하면 다른 스택에서 영향을 줄 수 있으므로 지역변수로 설정
                            //i,j가 아닌 x,y인 이유는 i,j를 넣게되면 앞에 선택된 위치들이 고정되고 맨 끝 위치만 움직이므로 x,y로 모든 경우의 수 고려하게한다.
                            DFS(x,y,cnt+1,sum+graph[i][j]);
                            visited[i][j]=false;
                        }
                    }
                }
            }
        }

    }
    public static boolean check(int x, int y){
        boolean flag=true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m){
                if(visited[nx][ny]){
                    flag=false;
                }
            }
        }
        return flag;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        DFS(0,0,0,0);
        System.out.println(answer);

    }
}