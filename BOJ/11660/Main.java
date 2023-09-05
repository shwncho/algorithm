import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int x1,y1,x2,y2;
    static int[][] graph;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph= new int[n+1][n+1];
        dp= new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+graph[i][j];
            }
        }

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());

            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());

            sb.append(dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1]).append("\n");
        }

        System.out.println(sb);



    }
}
