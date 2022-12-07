import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l;
        String tmp;
        while(true){
            StringBuilder sb = new StringBuilder();
            l= br.readLine();
            if(l.equals("0"))   break;
            sb.append(l);

            tmp=sb.reverse().toString();
            if(l.equals(tmp)) System.out.println("yes");
            else System.out.println("no");
        }

    }
}
