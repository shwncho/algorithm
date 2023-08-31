import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        int lenS = s.length();
        int lenT = t.length();

        String str1 = "";
        String str2 = "";

        for(int i=0; i<lenT; i++){
            str1 += s;
        }

        for(int i=0; i<lenS; i++){
            str2 += t;
        }

        if(str1.equals(str2)) System.out.println(1);
        else System.out.println(0);
    }
}
