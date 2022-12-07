import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hs = new HashSet<>();
        String str = br.readLine();
        String s;

        for(int i=1; i<=str.length(); i++){

            for(int j=0; j<=str.length()-i; j++){
                if(j==str.length()-i)   s=str.substring(j);
                else    s=str.substring(j,j+i);
                hs.add(s);
            }
        }

        System.out.println(hs.size());


    }
}
