import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer s1 = new StringTokenizer(s,"0");
        StringTokenizer s2 = new StringTokenizer(s,"1");

        System.out.println(Math.min(s1.countTokens(),s2.countTokens()));
    }
}
