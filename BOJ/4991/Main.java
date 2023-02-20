import java.util.*;
import java.io.*;

/**
 * 1. BFS로 청소기와 먼지들의 거리를 구한다.
 *  1.1 거리를 구하기 위해 위치를 저장할 리스를 구현한 뒤 0번에 청소기, 이후 인덱스에는 먼지들을 넣어준다.
 *  1.2 청소기와 먼지, 먼지와 먼지들의 거리를 리스트에 넣어준다.
 * 2. DFS(순열)를 통해 거리 리스트의 값로 먼지의 개수만큼 순회하면 가장 짧은 거리를 갱신해준다.
 */
class Point{
    public int x,y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Main{
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] graph;
    static int answer;
    static int[][] dis;
    static ArrayList<Point> list;
    static void solution(int dustCnt){
        answer=Integer.MAX_VALUE;
        dis=new int[dustCnt+1][dustCnt+1];
        //청소기와 먼지, 먼지와 먼의 모든 거리를 구해서 저장
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                int res = BFS(list.get(i),list.get(j));

                //도달할 수 없는 경우
                if(res==-1){
                    answer=-1;
                    return;
                }
                else{
                    //거리를 저장하는 것이므로 양방향 저장
                    dis[i][j]=dis[j][i]=res;
                }
            }
        }

        boolean[] selected = new boolean[list.size()];

        // n!을 통해 모든 경우의 수 중에서 가장 짧은 거리 탐색
        //dis[0][j] , 청소기 0 에서 먼지 j의 거리들을 전부 탐색
        permutation(0,0,0,selected);
    }
    static void permutation(int idx, int cnt, int sum, boolean[] selected){
        //먼지를 전부 제거
        if(cnt== list.size()-1){
            answer=Math.min(answer,sum);
        }
        else{
            for(int i=1; i<list.size(); i++){
                if(!selected[i]){
                    selected[i]=true;
                    permutation(i,cnt+1,sum+dis[idx][i],selected);
                    selected[i]=false;
                }
            }
        }
    }
    static int BFS(Point start, Point end){
        boolean[][] visited = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y]=true;
        graph[start.x][start.y]='.';

        int move=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Point tmp = q.poll();
                int x = tmp.x;
                int y = tmp.y;

                if(x==end.x && y==end.y)    return move;
                for(int j=0; j<4; j++){
                    int nx = x+dx[j];
                    int ny = y+dy[j];

                    //범위를 벗어났을 경우
                    if(nx<0 || nx>=n || ny<0 || ny>=m)  continue;

                    //이미 방문했거나 가구가 있는 곳 일경우
                    if(visited[nx][ny] || graph[nx][ny]=='x') continue;

                    visited[nx][ny]=true;
                    q.offer(new Point(nx,ny));
                }
            }
            move++;
        }

        //위 과정에서 목적지에 도달 못했을 경우
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st=new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if(m==0 && n==0)    break;
            graph = new char[n][m];
            list = new ArrayList<>();
            int dustCnt=0;
            for(int i=0; i<n; i++){
                String s = br.readLine();
                for(int j=0; j<m; j++){
                    graph[i][j]=s.charAt(j);
                    if(graph[i][j]=='*'){
                        list.add(new Point(i,j));
                        dustCnt++;
                    }
                    //0번에는 로봇청소기 위치
                    else if(graph[i][j]=='o'){
                        list.add(0,new Point(i,j));
                    }

                }
            }

            solution(dustCnt);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}