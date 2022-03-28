import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        // 공백 or null일 경우에 대한 defensive
        if(s.equals(" ") || s.isEmpty()){
            System.out.println(0);
            return;
        }
        s=s.trim();
        String[] str = s.split(" ");

        System.out.println(str.length);
        br.close();
    }
}
