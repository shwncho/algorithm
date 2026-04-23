import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = 30000;

        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (solve(arr, mid) <= M) {
                right = mid - 1;
                result = mid;
            } else left = mid + 1;
        }

        List<Integer> groups = new ArrayList<>();
        int sum = 0;
        int start = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum > result) {
                groups.add(i - start);
                start = i;
                sum = arr[i];
            }
        }
        groups.add(N - start);

        // 그룹 수가 M보다 적으면, 크기가 2 이상인 그룹을 앞에서 1개씩 떼어냄
        while (groups.size() < M) {
            for (int i = 0; i < groups.size(); i++) {
                if (groups.get(i) > 1) {
                    groups.set(i, groups.get(i) - 1);
                    groups.add(i, 1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");
        for (int i = 0; i < groups.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(groups.get(i));
        }
        System.out.println(sb);
    }

    private static int solve(int[] arr, int mid) {
        int cnt = 0;
        int sum = 0;

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] > mid) return n + 1;  // 단일 원소가 mid 초과면 불가능
            sum += arr[i];
            if (sum > mid) {
                cnt++;
                sum = arr[i];
            }
        }
        if (sum <= mid) cnt++;
        return cnt;
    }
}