import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            pQ.add(num);
        }

        int cnt = 0;

        while (cnt < T) {
            if(pQ.peek() < H) break;

            if(pQ.peek() != 1)  pQ.add(pQ.poll()/2);

            cnt++;
        }

        if(pQ.peek() < H) {
            System.out.println("YES");
            System.out.println(cnt);
        }
        else {
            System.out.println("NO");
            System.out.println(pQ.poll());
        }
    }
}
