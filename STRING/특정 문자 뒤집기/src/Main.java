import java.util.*;
public class Main{
    public String solution(String str){
        String answer;
        char[] s = str.toCharArray();
        int lt=0, rt=str.length()-1;
        while(lt<rt){
            if(!Character.isAlphabetic(s[lt]))  lt++;
            else if(!Character.isAlphabetic(s[rt])) rt--;
            else{
                char tmp = s[lt];
                s[lt]=s[rt];
                s[rt]=tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);
        return answer;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}



//public class Main {  내 풀이방식
//    public String solution(String str){
//        String answer="";
//        char[] c = str.toCharArray();
//        int lt=0,rt=str.length()-1;
//
//        while(lt<rt) {
//            if ((65 <= c[lt] && c[lt] <= 90) || (97 <= c[lt] && c[lt] <= 122)) {
//                if((65<= c[rt] && c[rt] <= 90) || (97 <= c[rt] && c[rt] <=122)){
//                    char tmp = c[lt];
//                    c[lt] = c[rt];
//                    c[rt] = tmp;
//                    lt++;
//                    rt--;
//                }
//                else{
//                    rt--;
//                    continue;
//                }
//            }
//            else{
//                lt++;
//            }
//
//
//
//
//        }
//        answer = String.valueOf(c);
//
//
//        return answer;
//    }
//    public static void main(String[] args) {
//        Main T = new Main();
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//
//        System.out.println(T.solution(str));
//
//
//    }
//}
