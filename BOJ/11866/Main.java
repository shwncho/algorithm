import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            q.offer(i);
        }


        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 1;
        while(!q.isEmpty()){
            if(cnt%K==0){
                list.add(q.poll());
            }
            else{
                int num =q.poll();
                q.offer(num);
            }
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i=0; i<list.size(); i++){
            if(i==list.size()-1){
                sb.append(list.get(i));
            }
            else{
                sb.append(list.get(i)).append(",").append(" ");
            }
        }

        sb.append(">");

        System.out.println(sb);



    }
}
