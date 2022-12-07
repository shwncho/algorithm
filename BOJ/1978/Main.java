import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1001];
        int N = Integer.parseInt(br.readLine());
        int answer=0;

        arr[0]=arr[1]=1;

        for(int i=2; i<=Math.sqrt(1000); i++){
            if(arr[i]==1)   continue;
            for(int j=2*i; j<=1000; j=j+i){
                arr[j]=1;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(st.nextToken());
            if(arr[x]==0)   answer++;
        }

        System.out.println(answer);

    }
}
