import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 총 합이 3으로 나누어 져야 한다.
        int sum =0;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i]= num;
            sum+=num;
        }

        // 2가 사용된 횟수
        int twoCnt = 0;
        for(int i=0; i<n; i++){
            twoCnt+=arr[i]/2;
        }

        if(sum%3==0 && twoCnt>=sum/3){
            System.out.println("YES");
        }
        else System.out.println("NO");




    }
}
