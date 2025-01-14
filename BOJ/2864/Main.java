import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        String A = st.nextToken();
        String B = st.nextToken();

        int n1 = Integer.parseInt(A.replaceAll("6","5"));
        int n2 = Integer.parseInt(B.replaceAll("6","5"));

        sb.append(n1+n2).append(" ");

        n1 = Integer.parseInt(A.replaceAll("5","6"));
        n2 = Integer.parseInt(B.replaceAll("5","6"));

        sb.append(n1+n2).append(" ");

        System.out.println(sb.toString());
    }
}
