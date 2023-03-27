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
    static int[][] graph,group;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        group = new int[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j]=s.charAt(j)-'0';
            }
        }

        int idx=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j]==0 && group[i][j]==0){
                    map.put(idx,BFS(i,j,idx));
                    idx++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(groupCount(i,j));
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static int BFS(int x, int y, int groupNumber){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        group[x][y]=groupNumber;
        int cnt=1;

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)  continue;

                if(graph[nx][ny]==0 && group[nx][ny]==0){
                    q.offer(new Point(nx,ny));
                    cnt++;
                    group[nx][ny]=groupNumber;
                }
            }
        }

        return cnt;
    }

    public static int groupCount(int x, int y){
        //본인 개수 1부터 시작
        int sum =1;
        Set<Integer> s = new HashSet<>();

        if(graph[x][y]==0)  return 0;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=m)  continue;

            if(graph[nx][ny]==0)    s.add(group[nx][ny]);
        }

        for(int t : s){
            sum+=map.get(t);
        }

        return sum%10;
    }
}