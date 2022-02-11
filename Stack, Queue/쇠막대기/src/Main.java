import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int solution(String s){
        int answer=0;
        Stack<Character> stk = new Stack<>();
        char[] ch = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(ch[i]=='(')  stk.push(ch[i]);
            else{
                stk.pop();
                if(ch[i-1]==')')    answer+=1;
                else    answer+=stk.size();
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solution(s));
    }
}
