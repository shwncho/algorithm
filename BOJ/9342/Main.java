import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String regex = "^[A-F]?A+F+C+[A-F]?$";
        StringBuilder sb = new StringBuilder();

        while(t-->0){
            String str = br.readLine();
            if(str.matches(regex))  sb.append("Infected!").append("\n");
            else sb.append("Good").append("\n");
        }

        System.out.println(sb);
    }
}
