import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[][] link = new int[n+1][2];
        int[] dp =new int[n+1];

        for(int i=1; i<=n; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            link[i][0]=a;
            link[i][1]=b;
        }

        Arrays.sort(link, (o1, o2) -> o1[0]-o2[0]);

        //LIS 방식
        int answer=1;
        for(int i=1; i<=n; i++){
            dp[i]=1;
            for(int j=1; j<i; j++){
                if(link[i][1]>link[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            answer=Math.max(dp[i],answer);
        }

        System.out.println(n-answer);


    }
}
