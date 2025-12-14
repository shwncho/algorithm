import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 0}); // {현재 위치, 이동 횟수}
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int pos = curr[0];
            int moves = curr[1];

            if (pos == n * n) return moves; // 도착

            // 주사위 1~6칸 이동
            for (int dice = 1; dice <= 6 && pos + dice <= n * n; dice++) {
                int next = pos + dice;
                int[] rc = getPosition(next, n);
                int r = rc[0], c = rc[1];

                if (board[r][c] != -1) {
                    next = board[r][c]; // 뱀/사다리 이동
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, moves + 1});
                }
            }
        }

        return -1; // 도달 불가능
    }

    // 번호 → (row, col) 변환
    private int[] getPosition(int num, int n) {
        int quot = (num - 1) / n;
        int rem = (num - 1) % n;
        int row = n - 1 - quot;
        int col = (quot % 2 == 0) ? rem : (n - 1 - rem);
        return new int[]{row, col};
    }
}