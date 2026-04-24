import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static long N;
    static int[] rides;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rides = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            rides[i] = Integer.parseInt(st.nextToken());
        }

        // 예외 처리: 처음에 바로 탈 수 있는 경우
        if (N <= M) {
            System.out.println(N);
            return;
        }

        long left = 0;
        long right = 60000000000L; // 충분히 큰 값 (30 * 2e9)

        long time = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = getCount(mid);

            if (count >= N) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // time 직전까지 탄 인원
        long prevCount = getCount(time - 1);

        // 마지막 아이 찾기
        for (int i = 0; i < M; i++) {
            if (time % rides[i] == 0) {
                prevCount++;
                if (prevCount == N) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }

    static long getCount(long t) {
        long count = 0;
        for (int i = 0; i < M; i++) {
            count += (t / rides[i]) + 1;
        }
        return count;
    }
}