import java.util.*;
import java.io.*;

public class Main{
    static int n,k;
    static int[][] dp = new int[10][1<<10];
    static int[][] graph = new int[10][10];
    static final int INF = 10000000;
    public static int TSP(int now, int visited){
        // 모든 경로를 다 돌았을 경우
        if(visited==k){

            //원래 자리로 돌아갈 수 있는 경로가 있을 경우
            if(graph[now][0]>0){
                return graph[now][0];
            }

            return INF;
        }
        //이미 값이 기록된 적이 있으면
        if(dp[now][visited]!=0)    return dp[now][visited];

        dp[now][visited]=INF;

        for(int i=0; i<n; i++){

            //이미 방문한 곳 or 갈 수 없는 곳
            if((visited & 1<<i) !=0 || graph[now][i]==0)    continue;

            //현재 위치와 지금까지 방문한 위치 포함해서 값 추출
            int tmp = TSP(i, visited | 1<<i);
            dp[now][visited] = Math.min(dp[now][visited],graph[now][i]+tmp);
        }

        return dp[now][visited];

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = (1<<n) -1;

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(TSP(0,1));
    }
}