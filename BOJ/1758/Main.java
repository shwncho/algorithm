import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Long> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        long sum = 0;
        for(int i=0; i<N; i++){
            long tmp = list.get(i)-(i+1-1);
            if(tmp>=0)  sum+=tmp;
        }

        System.out.println(sum);

    }
}
