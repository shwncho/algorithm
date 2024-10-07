import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Set<String> set = new TreeSet<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            if(st.nextToken().equals("enter"))  set.add(name);
            else{
                set.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String name : set)  sb.append(name).append("\n");

        System.out.println(sb);
    }
}
