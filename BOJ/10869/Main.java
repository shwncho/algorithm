import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(A+B).append("\n");
        sb.append(A-B).append("\n");
        sb.append(A*B).append("\n");
        sb.append(A/B).append("\n");
        sb.append(A%B).append("\n");

        System.out.println(sb);
    }
}
