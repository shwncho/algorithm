import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] cache = new boolean[N+1];
        System.out.println(solution(N, cache, K));
    }

    private static int solution(int N, boolean[] cache, int K) {
        for(int i = 2; i<= N; i++){
            if(cache[i])    continue;
            for(int j = 1; i*j<= N; j++){
                if(!cache[i*j]) {
                    K--;
                    cache[i*j] = true;
                    if(K==0){
                        return i*j;
                    }
                }
            }
        }
        return -1;
    }
}
