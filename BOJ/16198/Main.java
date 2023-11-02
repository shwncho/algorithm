import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        DFS(0);

        System.out.println(answer);
    }

    public static void DFS(int sum){
        if(list.size()==2){
            answer = Math.max(answer, sum);
            return;
        }
        for(int i=1; i<list.size()-1; i++){
            int tmp = list.get(i);
            int multiple = list.get(i-1) * list.get(i+1);
            list.remove(i);
            DFS(sum+multiple);
            list.add(i,tmp);
        }
    }
}
