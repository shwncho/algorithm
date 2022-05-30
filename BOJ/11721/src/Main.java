import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        while(s.length()>0){
            if(s.length()>=10){
                System.out.println(s.substring(0,10));
                s=s.substring(10);
            }
            else{
                System.out.println(s);
                s="";
            }
        }

    }
}
