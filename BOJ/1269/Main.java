import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++){
            int num = Integer.parseInt(st.nextToken());

            set.add(num);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<B; i++){
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num))   set.remove(num);
            else set.add(num);
        }

        System.out.println(set.size());
    }
}
