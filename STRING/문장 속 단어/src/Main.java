import java.util.*;
public class Main{
    public String solution(String str){
        String answer="";
        int m = Integer.MIN_VALUE;
        String[] s=str.split(" ");
        for(String x:s){
            int len = x.length();
            if(len>m){
                m=len;
                answer=x;
            }
        }

        return answer;
    }



    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        System.out.print(T.solution(str));
    }
}






//public class Main {
//    public String solution(String s){
//        String answer="";
//        String[] str;
//        str=s.split(" ");
//        int max=str[0].length();
//        answer=str[0];
//        for(int i=1; i<str.length; i++){
//            if(str[i].length()>max){
//                max=str[i].length();
//                answer=str[i];
//            }
//
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Main T = new Main();
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        System.out.println(T.solution(s));
//
//    }
//}
