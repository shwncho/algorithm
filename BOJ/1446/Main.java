import java.io.*;
import java.util.*;
public class Main {
    static class Node implements Comparable<Node> {
        int vex;
        int cost;

        Node (int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for(int i=0; i<=D; i++) {
            graph.add(new ArrayList<>());
        }
        final int INF = 1_000_000;
        int[] dis = new int[D+1];

        Arrays.fill(dis, INF);
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            if(to > D)  continue;
            if (to - from <= len) continue;
            graph.get(from).add(new Node(to, len));
        }

        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0,0));
        dis[0] = 0;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(dis[cur.vex] < cur.cost) continue;
            // 지름길 이용
            for(Node next : graph.get(cur.vex)) {
                if(dis[next.vex] > cur.cost + next.cost) {
                    dis[next.vex] = cur.cost + next.cost;
                    q.offer(new Node(next.vex, cur.cost + next.cost));
                }
            }
            // 그냥 거리 이용
            if(cur.vex + 1 <= D) {
                if(dis[cur.vex + 1] > cur.cost + 1) {
                    dis[cur.vex + 1] = cur.cost + 1;
                    q.offer(new Node(cur.vex + 1, cur.cost + 1));
                }
            }
        }

        System.out.println(dis[D]);
    }
}
