import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String str = br.readLine().toLowerCase();
            sb.append(checkPalindrome(str) ? "Yes" : "No").append("\n");
        }
        System.out.println(sb);
    }

    public static boolean checkPalindrome(String str){
        int s = 0;
        int e = str.length()-1;

        while(s<=e){
            if(str.charAt(s++) != str.charAt(e--))  return false;
        }

        return true;
    }
}
