import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer="";
        str=str.toLowerCase();
        StringBuilder sb = new StringBuilder(str);

        if(sb.reverse().toString().equals(str)) answer+="YES";
        else    answer+="NO";

        return answer;

        /* 다른풀이
        String answer = "YES";
        str=str.toUpperCase();
        int len=str.length();
        for(int i=0; i<len/2; i++){
            if(str.charAt(i)!=str.charAt(len-i-1))  return "NO";
         }
         return answer;
         */


    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));

    }
}
