import java.io.*;
import java.util.*;
public class Main {
    static int[] parent=new int[100001];
    static int[] ch = new int[100001];
    public static void BFS(int s, int e){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        ch[s]=1;
        while(!Q.isEmpty()){
            int x = Q.poll();

            if(x==e)    return;

            for(int j=0; j<3; j++){
                int nx;
                if(j==0)    nx=x+1;
                else if(j==1)   nx=x-1;
                else nx=x*2;


                if(nx< 0 || nx>100000)  continue;

                if(ch[nx]==0){
                    ch[nx]=ch[x]+1;
                    Q.offer(nx);
                    parent[nx]=x;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        BFS(s,e);

        Stack<Integer> stk = new Stack<>();
        stk.push(e);
        int prev = e;

        while(prev!=s){
            stk.push(parent[prev]);
            prev=parent[prev];
        }

        sb.append(ch[e]-1).append("\n");
        while(!stk.isEmpty()){
            sb.append(stk.pop()).append(" ");
        }

        System.out.println(sb);

    }
}
