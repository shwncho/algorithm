import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;

        for(int i=0; i<N; i++){
            char[] chars = br.readLine().toCharArray();
            int num = 0;
            for(int j=0; j<M; j++){
                if(chars[j] == '0'){
                    num++;
                    if(num>=K)  answer++;
                }
                else    num = 0;
            }
        }

        System.out.println(answer);
    }
}
