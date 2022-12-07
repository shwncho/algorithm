import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        for(int x:arr){
            sb.append(x).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
