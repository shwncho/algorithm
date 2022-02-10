import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int solution(String s){
        int answer=0;
        char[] ch = s.toCharArray();
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(ch[i]))    stk.push(Character.getNumericValue(ch[i]));
            else{
                int b=stk.pop();
                int a=stk.pop();
                if(ch[i]=='*')  stk.push(a*b);
                else if(ch[i]=='/') stk.push(a/b);
                else if(ch[i]=='+') stk.push(a+b);
                else    stk.push(a-b);
            }
        }
        answer=stk.pop();
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
