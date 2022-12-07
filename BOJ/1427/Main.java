import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split("");
        Arrays.sort(str,Comparator.reverseOrder());

        for(String s: str){
            bw.write(s);
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
