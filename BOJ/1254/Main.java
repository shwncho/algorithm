import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = s.length();
        for(int i=0; i<s.length(); i++){
            if(checkPalindrome(s.substring(i))) break;
            else answer++;
        }

        System.out.println(answer);
    }

    public static boolean checkPalindrome(String str){
        int s = 0;
        int e = str.length()-1;

        while(s<=e){
            if(str.charAt(s++)!=str.charAt(e--))    return false;
        }

        return true;
    }
}