import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] check = new boolean[n+1][n+1];

        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            check[a][b]=true;
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(check[i][k] && check[k][j])  check[i][j]=true;
                }
            }
        }

        int[] cnt = new int[n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(check[i][j] || check[j][i])  cnt[i]++;
            }
        }

        int answer=0;
        for(int num : cnt){
            if(num==n-1)    answer++;
        }

        System.out.println(answer);

    }
}
