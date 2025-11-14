import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        int d,c;
        Node(int d, int c) {
            this.d = d;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Node> problems = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>();

        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            problems.add(new Node(d, c));
        }
        Collections.sort(problems, (a,b) -> (a.d - b.d));

        for(Node problem : problems){
            q.add(problem.c);
            if(q.size() > problem.d){
                q.poll();
            }
        }

        while(!q.isEmpty()) answer+=q.poll();

        System.out.println(answer);
    }
}
