import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int money = Integer.parseInt(br.readLine());

            sb.append(money/25).append(" ");
            money %= 25;

            sb.append(money/10).append(" ");
            money %= 10;

            sb.append(money/5).append(" ");
            money %= 5;

            sb.append(money).append(" ");

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
