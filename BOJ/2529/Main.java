import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[] ch;
    static boolean[] visited = new boolean[10];
    static ArrayList<Long> answer = new ArrayList<>();

    public static void DFS(int L, int[] arr) {
        if (L == n + 1) {
            if (check(arr)) {
                String s = "";
                for (int i = 0; i < n + 1; i++) {
                    s += String.valueOf(arr[i]);
                }

                answer.add(Long.parseLong(s));
            }
        } else {
            for (int num = 0; num < 10; num++) {
                if (!visited[num]) {
                    visited[num] = true;
                    arr[L] = num;
                    DFS(L + 1, arr);
                    visited[num] = false;

                }
            }
        }
    }

    public static boolean check(int[] arr) {
        boolean flag = true;

        for (int i = 0; i < n; i++) {

            if (ch[i] == '>') {
                if (arr[i] < arr[i + 1]) flag = false;
            } else {
                if (arr[i] > arr[i + 1]) flag = false;
            }

            if (!flag) break;
        }

        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        ch = new char[n];
        for (int i = 0; i < n; i++) {
            ch[i] = st.nextToken().charAt(0);
        }

        int[] arr = new int[n + 1];

        DFS(0, arr);

        Collections.sort(answer);

        String tmp = answer.get(answer.size() - 1).toString();
        String max = tmp.length() == n ? "0" + tmp : tmp;
        System.out.println(max);
        tmp = answer.get(0).toString();
        String min = tmp.length() == n ? "0" + tmp : tmp;
        System.out.println(min);

    }
}