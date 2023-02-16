import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int len = s.length();
        int cnt=0;
        for(int i=1; i<len; i++) {
            cnt += (Math.pow(10, i - 1) * 9)*i;
        }
        cnt+=(n-Math.pow(10,len-1)+1)*len;

        System.out.println(cnt);

    }
}