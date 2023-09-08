import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());

        while(true){
            if(isPrime(n) && isPalindrome(n)) break;
            n++;
        }

        System.out.println(n);

    }
    public static boolean isPrime(long num){
        if(num==1)  return false;
        for(long i=2; i<=Math.sqrt(num); i++){
            if(num%i==0)    return false;
        }
        return true;
    }

    public static boolean isPalindrome(long num){
        String str = String.valueOf(num);
        int s = 0;
        int e = str.length()-1;

        while(s<=e){
            if(str.charAt(s++)!=str.charAt(e--))    return false;
        }

        return true;
    }
}
