import java.util.*;
class Solution {

    static class Point{
        int x, y;
        Point(int x , int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int n,m;
    static int[][] oil;
    public int solution(int[][] land) {
        int answer = 0;
        n = land[0].length;
        m = land.length;
        oil = new int[m][n];
        visited = new boolean[m][n];
        Map<Integer, Integer> map = new HashMap<>();
        int id = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[j][i]==1 && !visited[j][i]){
                    int size = BFS(land,j,i,id);
                    map.put(id++,size);
                }
            }
        }

        for(int i=0; i<n; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<m; j++){
                if(land[j][i]==1){
                    set.add(oil[j][i]);
                }
            }
            int sum = 0;
            for(int key : set){
                sum+=map.get(key);
            }
            answer = Math.max(answer ,sum);
        }

        return answer;
    }
    private int BFS(int[][] land, int x, int y, int id){
        oil[x][y]=id;
        visited[x][y]=true;
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        int size = 1;

        while(!Q.isEmpty()){
            int len = Q.size();
            for(int k=0; k<len; k++){
                Point tmp = Q.poll();
                for(int i=0; i<4; i++){
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if(nx<0 || nx>=m || ny<0 || ny>=n)  continue;

                    if(land[nx][ny]==1 && !visited[nx][ny]){
                        visited[nx][ny]=true;
                        size++;
                        oil[nx][ny]=id;
                        Q.offer(new Point(nx, ny));
                    }
                }

            }
        }

        return size;
    }
}