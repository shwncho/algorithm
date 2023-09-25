import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int cnt = str.charAt(0)=='W' && str.charAt(1)=='E' ? 1 : 0;
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i)=='W' && str.charAt(i-1)=='E')  cnt++;
        }

        System.out.println(cnt);
    }
}