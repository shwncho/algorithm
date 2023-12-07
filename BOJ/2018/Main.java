import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt=0;

        for(int i=1; i<=N/2; i++){
            int sum = 0;
            int num = i;
            while(sum<N){
                sum+=num++;
                if(sum==N){
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt+1);
    }
}
