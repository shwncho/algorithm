import java.util.*;
import java.io.*;

public class Main{
    static int F,S,G,U,D;
    public static String BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        boolean[] visited = new boolean[1000001];

        int cnt=0;
        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0; i<len; i++){
                int x = q.poll();

                if(x==G)    return String.valueOf(cnt);

                if(x+U<=F && !visited[x+U]){
                    visited[x+U]=true;
                    q.offer(x+U);
                }

                if(x-D>=1 && !visited[x-D]){
                    visited[x-D]=true;
                    q.offer(x-D);
                }
            }

            cnt++;

        }

        return "use the stairs";
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        System.out.println(BFS());


    }
}