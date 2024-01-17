import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] alpha = new int[26];
        for(int i=0; i<str.length(); i++){
            alpha[str.charAt(i)-'A']++;
        }

        int cnt = 0;
        for(int i=0; i<alpha.length; i++){
            if(alpha[i]%2==1) cnt++;
        }

        StringBuilder sb = new StringBuilder();
        String answer = "";
        if(cnt>=2){
            System.out.println("I'm Sorry Hansoo");
        }
        else{
            for(int i=0; i<alpha.length; i++){
                for(int j=0; j<alpha[i]/2; j++){
                    sb.append((char)(i+'A'));
                }
            }

            answer+=sb.toString();
            String end = sb.reverse().toString();

            for(int i=0; i<alpha.length; i++){
                if(alpha[i]%2==1)   answer+=(char)(i+'A');
            }

            answer += end;

            System.out.println(answer);

        }
    }
}
