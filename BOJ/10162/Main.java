import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        System.out.println(solution(T));
    }

    private static String solution(int T){
        StringBuilder sb = new StringBuilder();
        int A = 300;
        int B = 60;
        int C = 10;

        if(T % 10 != 0) sb.append("-1");
        else{
            sb.append(T/A).append(" ");
            T %= 300;

            sb.append(T/B).append(" ");
            T %= 60;

            sb.append(T/C);
        }

        return sb.toString();
    }
}
