import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp= new int[16][1<<16];
    static int[][] graph=new int[16][16];
    static int n,k;
    static int INF = 1000000000;
    public static int TSP(int now, int visited){

        //종료조건
        if(visited==k){
            // 현재 노드에서 0번으로 가는 경로가 있을 경우
            if(graph[now][0]>0){
                return graph[now][0];
            }

            //순회할 수 없는 경우
            return INF;
        }

        //이미 계산한 값이 있으면
        if(dp[now][visited]!=0) return dp[now][visited];

        dp[now][visited]=INF;

        for(int i=0; i<n; i++){

            // 이미 방문한 곳 or 갈 수 없는 곳
            if((visited & (1<<i))!=0 || graph[now][i]==0)   continue;

            int tmp = TSP(i,  visited | (1<<i));
            dp[now][visited]=Math.min(dp[now][visited],graph[now][i]+tmp);

        }
        return dp[now][visited];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = (1<<n) - 1;

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(TSP(0,1));

    }
}
