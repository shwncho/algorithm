import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        if(checkPalindrome(str)) System.out.println(1);
        else System.out.println(0);

    }

    public static boolean checkPalindrome(char[] str){
        int s = 0;
        int e = str.length-1;

        while(s<=e){
            if(str[s++]!=str[e--]){
                return false;
            }
        }

        return true;
    }
}
