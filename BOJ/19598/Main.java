import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] lecture = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lecture[i] = new int[]{s, e};
        }

        Arrays.sort(lecture, (a,b) -> a[0] - b[0]);
        Queue<Integer> pQ = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            if(!pQ.isEmpty() && pQ.peek() <= lecture[i][0]) {
                pQ.poll();
            }
            pQ.offer(lecture[i][1]);
        }

        System.out.println(pQ.size());
    }
}
