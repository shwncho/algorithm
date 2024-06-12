import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[][] relations;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        relations = new int[M][2];
        visited = new boolean[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            relations[i][0] = Integer.parseInt(st.nextToken());
            relations[i][1] = Integer.parseInt(st.nextToken());
        }
        DFS(0,0);

        //관계 * 2를 해야 인원 수
        answer*=2;

        //로봇춤을 출 인원이 있는지
        if(answer<N)    answer++;

        System.out.println(answer);
    }
    private static void DFS(int idx, int cnt){
        if(idx==M){
            answer = Math.max(answer, cnt);
            return;
        }
        //한 친구라도 이미 짝을 이뤘으면 다음 관계 탐색
        if(visited[relations[idx][0]] || visited[relations[idx][1]])  DFS(idx+1,cnt);
        else{
            //친구 쌍 선택
            visited[relations[idx][0]]=true;
            visited[relations[idx][1]]=true;

            DFS(idx+1,cnt+1);

            //친구 상 선택하지 않았을 때
            visited[relations[idx][0]]=false;
            visited[relations[idx][1]]=false;

            DFS(idx+1,cnt);
        }
    }
}
