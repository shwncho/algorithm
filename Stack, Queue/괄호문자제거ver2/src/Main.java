import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static String solution(String s){
        String answer="";
        Stack<Character> stk = new Stack<>();
        for(char x:s.toCharArray()){
            if(x==')'){
                while(stk.pop()!='(');
            }
            else    stk.push(x);
        }
        for(int i=0; i<stk.size(); i++) answer+=stk.get(i);
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
