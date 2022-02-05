import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static String solution(String s){
        String answer="";
        Stack<Character> stk = new Stack<>();
        String t="";
        for(char x:s.toCharArray()){
            if(x!=')')  stk.push(x);
            else if(x==')'){
                while(!(stk.peek()=='(')){
                    stk.pop();
                }
                stk.pop();
            }
        }
        while(!(stk.isEmpty())){
            answer+=stk.pop();
        }
        StringBuilder sb = new StringBuilder(answer);
        answer=sb.reverse().toString();
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
