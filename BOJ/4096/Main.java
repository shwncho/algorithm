import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true){
            String n = br.readLine();

            if(n.equals("0"))    break;

            sb.append(countPalindrome(n)).append("\n");
        }


        System.out.println(sb);


    }

    public static int countPalindrome(String number){
        int cnt = 0;

        while(true){
            if(checkPalindrome(number)) break;
            else{
                int n = Integer.parseInt(number);
                n++;
                int d = number.length() - String.valueOf(n).length();
                String s = String.valueOf(n);
                for(int i=0; i<d; i++){
                    s = "0" + s;
                }
                number = s;
                cnt++;
            }
        }



        return cnt;
    }

    public static boolean checkPalindrome(String str){
        int s = 0;
        int e = str.length()-1;

        while(s<=e){
            if(str.charAt(s++)!=str.charAt(e--)) return false;
        }
        return true;
    }
}
