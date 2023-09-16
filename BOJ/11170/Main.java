import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int cnt=0;
            for(int i=n; i<=m; i++){
                int tmp = i;
                if(tmp==0){
                    cnt++;
                    continue;
                }
                while(tmp>0){
                    int num = tmp%10;

                    if(num == 0)    cnt++;
                    tmp/=10;
                }

            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

    }
}
