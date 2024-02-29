import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] degree = new int[13];
        ArrayList<ArrayList<Integer>> connection = new ArrayList<>();
        for (int i = 0; i < 13; i++) connection.add(new ArrayList<>());
        for (int i = 0; i < 12; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            degree[a]++;
            degree[b]++;

            connection.get(a).add(b);
            connection.get(b).add(a);
        }

        for(int i=1; i<=12; i++){

            if(degree[i]==3){
                int sum=0;
                for(int x : connection.get(i))  sum+=degree[x];

                if(sum==6){
                    System.out.println(i);
                    break;
                }
            }
        }


    }

}