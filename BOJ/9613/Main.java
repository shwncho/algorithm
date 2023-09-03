import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-->0){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++)  list.add(Integer.parseInt(st.nextToken()));

            Collections.sort(list, Collections.reverseOrder());

            long sum = 0;
            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    sum += gcd(list.get(i), list.get(j));
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a%b);
    }
}
