import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] strs = new String[N];

        for(int i = 0; i < N; i++ ){
            strs[i] = br.readLine();
        }

        int K = Integer.parseInt(br.readLine());

        for(String s : strs) {

            int zeroCnt = 0;
            for(int i=0; i<M; i++){
                if(s.charAt(i) == '0') zeroCnt++;
            }

            if(zeroCnt <= K && (K - zeroCnt) % 2 == 0) {
                int samePatternStrCnt = 0;
                for(int j=0; j<N; j++) {

                    if(s.equals(strs[j])) samePatternStrCnt++;
                }
                answer = Math.max(answer, samePatternStrCnt);
            }
        }

        System.out.println(answer);
    }
}
