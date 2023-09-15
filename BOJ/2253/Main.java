import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Jump{
    int position, jumpSize, jumpCnt;
    Jump(int position, int jumpSize, int jumpCnt){
        this.position = position;
        this.jumpSize =jumpSize;
        this.jumpCnt = jumpCnt;
    }
}
public class Main {
    static int n, m;
    //List의 contain 시간 복잡도 O(n), Set은 O(1) 이므로, 시간 초과 대비 Set
    static Set<Integer> smallStones = new HashSet<>();
    static boolean[][] visited = new boolean[10001][10001];

    public static int BFS() {
        Queue<Jump> Q = new LinkedList<>();
        Q.offer(new Jump(2,1, 1));
        visited[1][2]=true;
        while(!Q.isEmpty()){
            Jump tmp = Q.poll();

            for(int i=0; i<3; i++){

                //x-1 점프
                if(i==0){
                    if(tmp.jumpSize-1 >0){
                        int next = tmp.position + tmp.jumpSize-1;

                        if(next == n)   return tmp.jumpCnt+1;

                        if(next < n && !smallStones.contains(next) && !visited[tmp.position][next]){
                            visited[tmp.position][next] = true;
                            Q.offer(new Jump(next, tmp.jumpSize-1, tmp.jumpCnt+1));
                        }
                    }
                }

                //x 점프
                else if(i==1){
                    int next = tmp.position + tmp.jumpSize;

                    if(next == n)   return tmp.jumpCnt+1;

                    if(next < n && !smallStones.contains(next) && !visited[tmp.position][next]){
                        visited[tmp.position][next] = true;
                        Q.offer(new Jump(next, tmp.jumpSize, tmp.jumpCnt+1));
                    }
                }
                else{
                    int next = tmp.position + tmp.jumpSize+1;

                    if(next == n)   return tmp.jumpCnt+1;

                    if(next < n && !smallStones.contains(next) && !visited[tmp.position][next]){
                        visited[tmp.position][next] = true;
                        Q.offer(new Jump(next, tmp.jumpSize+1, tmp.jumpCnt+1));
                    }
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++){
            smallStones.add(Integer.parseInt(br.readLine()));
        }

        if(smallStones.contains(2)) System.out.println(-1);
        else System.out.println(BFS());

    }
}

