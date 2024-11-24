import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    q.add(num);
                    break;
                case "pop":
                    if(!q.isEmpty()){
                        sb.append(q.poll()).append("\n");
                    }
                    else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(!q.isEmpty())    sb.append(0).append("\n");
                    else sb.append(1).append("\n");
                    break;
                case "front":
                    if(!q.isEmpty()){
                        sb.append(q.peekFirst()).append("\n");
                    }
                    else sb.append(-1).append("\n");
                    break;
                case "back":
                    if(!q.isEmpty()){
                        sb.append(q.peekLast()).append("\n");
                    }
                    else sb.append(-1).append("\n");
                    break;
            }
        }

        System.out.println(sb);

    }
}
