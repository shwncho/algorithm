import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int A = Integer.parseInt(br.readLine());

        int[] colSums = new int[M];
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                colSums[j] += arr[i][j];
            }
        }

        int answer = 0;
        int currentSum = 0;

        for (int j = 0; j < A; j++) {
            currentSum += colSums[j];
        }
        answer = currentSum;

        for (int start = 1; start <= M - A; start++) {
            currentSum = currentSum - colSums[start - 1] + colSums[start + A - 1];
            answer = Math.max(answer, currentSum);
        }

        System.out.println(answer);
    }
}
