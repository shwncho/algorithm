import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String str = br.readLine().split("\\.")[1];
            map.put(str, map.getOrDefault(str,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(String s : map.keySet()){
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }

        System.out.println(sb);

    }
}
