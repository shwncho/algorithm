import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());


        //value, idx 구조로 저장
        Deque<int[]> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            //새로 들어오는 값보다 큐의 값이 더 크다면 뽑기
            while(!q.isEmpty() && q.peekLast()[0] > num) q.pollLast();
            q.offer(new int[]{num, i});
            //윈도우의 크기를 벗어나면 뽑기
            if(q.peek()[1] < i - (L-1)) q.poll();
            sb.append(q.peek()[0]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
