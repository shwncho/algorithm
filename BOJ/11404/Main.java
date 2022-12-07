import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dis = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dis[i][j]=100000000;
                if(i==j)    dis[i][j]=0;
            }
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

//          이게 핵심  시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
            dis[a][b]=Math.min(dis[a][b],c);
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dis[i][j]>dis[i][k]+dis[k][j]){
                        dis[i][j]=dis[i][k]+dis[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(dis[i][j]==100000000){
                    dis[i][j]=0;
                }
                sb.append(dis[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());



    }
}

