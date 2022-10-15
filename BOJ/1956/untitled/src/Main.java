import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());



        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dis = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dis[i][j]=INF;
            }
        }

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dis[a][b]=c;
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dis[i][j]>dis[i][k]+dis[k][j])   dis[i][j]=dis[i][k]+dis[k][j];
                }
            }
        }

        int answer=INF;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(dis[i][j]!=INF && dis[j][i]!=INF){
                    answer=Math.min(answer,dis[i][j]+dis[j][i]);
                }
            }
        }

        System.out.println(answer!=INF ? answer : -1);




    }
}
