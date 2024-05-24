import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String S = br.readLine();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(solution(S));

    }

    private static int solution(String s){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<8; k++) {
                    if(DFS(s,0,i,j,k))    return 1;
                }
            }
        }

        return 0;
    }

    private static boolean DFS(String s, int depth, int x, int y, int direction){
        if(depth==s.length())   return true;

        //범위를 넘어가면
        if(x<0 || x>=N || y<0 || y>=M)  return false;

        //글자가 일치하지 않으면
        if(map[x][y] != s.charAt(depth))    return false;

        //방문한 곳이면
        if(visited[x][y])   return false;

        visited[x][y] = true;

        int nx = x + dx[direction];
        int ny = y + dy[direction];

        if(DFS(s,depth+1,nx,ny,direction))    return true;

        //다 찾아도 없으면
        visited[x][y]=false;

        return false;
    }
}
