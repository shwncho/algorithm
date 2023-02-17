import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){

            st=new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //최소공배수만큼 돌았는데 안나오면 -1
            int lcm = M*N/gcd(M,N);

            int cnt=0;
            while(true){

                if((cnt*M+x)>lcm){
                    sb.append(-1).append("\n");
                    break;
                }

                // cnt+M+x 로 x 년을 만족 시켜준 상태로 y가 만족되는지를 cnt+M+X 만큼 증가하면서 검증
                if((cnt*M+x-y)%N==0){
                    sb.append(cnt*M+x).append("\n");
                    break;
                }

                cnt ++;

            }


        }
        System.out.println(sb);
    }
    public static int gcd(int a, int b){
        if(b==0)    return a;
        return gcd(b, a%b);
    }
}