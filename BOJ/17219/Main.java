import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i=0; i<M; i++){
            String target = br.readLine();
            sb.append(map.get(target)).append("\n");
        }

        System.out.println(sb);
    }
}
