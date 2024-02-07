import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int N = Integer.parseInt(br.readLine());

            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);

            sb.append(list.get(0)).append(" ").append(list.get(N-1)).append("\n");
        }

        System.out.println(sb);
    }
}
