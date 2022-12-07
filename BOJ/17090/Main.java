import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int answer=0;
    static char[][] graph;
    static boolean[][] visited;
    public static boolean solution(int x, int y){
        boolean result = false;
        if(x>n || y>m || x<1 || y<1)    return true;

        if(graph[x][y]=='T') return true;
        else if(graph[x][y]=='F')   return false;

        if(visited[x][y])    return false;

        visited[x][y]=true;
        if(graph[x][y]=='U'){
            result=solution(x-1,y);
        }
        else if(graph[x][y]=='R'){
            result=solution(x,y+1);
        }
        else if(graph[x][y]=='D'){
            result=solution(x+1,y);
        }
        else if(graph[x][y]=='L'){
            result=solution(x,y-1);
        }

        graph[x][y]=result ? 'T' : 'F';
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        graph=new char[n+1][m+1];
        visited=new boolean[n+1][m+1];

        for(int i=1; i<=n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                graph[i][j] = s.charAt(j-1);
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(solution(i,j))   answer++;
            }
        }
        System.out.println(answer);


    }
}
