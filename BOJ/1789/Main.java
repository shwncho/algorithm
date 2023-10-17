import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long num = 0;
        long cnt = 0;
        while(true){
            num += cnt;
            if(num>n)   break;
            cnt++;
        }
        System.out.println(cnt-1);
    }
}