import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] B = new int[N]; // 각 구간별로 칠해진 번호를 저장할 배열

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            for (int j = L - 1; j < R; j++) {
                B[j] = i + 1;
            }
        }

        Set<Integer> colors = new HashSet<>();
        for (int num : B) {
            if (num != 0) {
                colors.add(num);
            }
        }

        System.out.println((long)Math.pow(2, colors.size()));
    }
}
