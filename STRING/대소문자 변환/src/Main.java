import java.util.*;

public class Main{

    public String solution(String s){
        String answer = "";
        for(char x: s.toCharArray()){
            if(Character.isLowerCase(x))    answer+=Character.toUpperCase(x);
            else answer+=Character.toLowerCase(x);
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }
}















//public class Main{ 내 풀이
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//
//        for(char x:s.toCharArray()){
//            if(Character.isUpperCase(x)){
//                System.out.print(Character.toLowerCase(x));
//
//            }
//            else{
//                System.out.print(Character.toUpperCase(x));
//            }
//        }
//
//    }
//}