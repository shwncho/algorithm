import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        int pos;
        int cnt;
        Node(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer,Integer> snakeAndradder = new HashMap<>();

        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            snakeAndradder.put(x,y);
        }

        System.out.println(solution(snakeAndradder));
    }
    private static int solution(Map<Integer,Integer> snakeAndradder) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1,0));
        boolean[] visited = new boolean[101];
        visited[1] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.pos == 100){
                return now.cnt;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now.pos + i;
                if (next > 100) continue;

                if (snakeAndradder.containsKey(next)) {
                    next = snakeAndradder.get(next);
                }

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new Node(next, now.cnt + 1));
                }
            }
        }

        return -1;
    }
}
