import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dy;
    public static int solution(int n){
        for(int i=3; i<=n; i++){
            dy[i]=dy[i-2]+dy[i-1];
        }


        return dy[n]+dy[n-1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());

        dy=new int[n+1];
        dy[1]=1;
        dy[2]=2;
        System.out.println(solution(n));
    }
}
