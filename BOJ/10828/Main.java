import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                stk.push(x);
            }
            else if(s.equals("pop")){
                if(stk.isEmpty())   sb.append(-1).append("\n");
                else sb.append(stk.pop()).append("\n");
            }
            else if(s.equals("size"))   sb.append(stk.size()).append("\n");
            else if(s.equals("empty"))  sb.append(stk.isEmpty() ? 1 : 0).append("\n");
            else{
                if(stk.isEmpty())   sb.append(-1).append("\n");
                else sb.append(stk.peek()).append("\n");
            }
        }

        System.out.println(sb);

    }
}
