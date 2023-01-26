import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n =Integer.parseInt(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(st.nextToken());
            map.put(x,map.getOrDefault(x,0)+1);
        }

        int m =Integer.parseInt(br.readLine());

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int x = Integer.parseInt(st.nextToken());
            Integer tmp = map.get(x);
            if(tmp==null)   sb.append(0).append(" ");
            else sb.append(map.get(x)).append(" ");
        }


        System.out.println(sb);

    }
}
