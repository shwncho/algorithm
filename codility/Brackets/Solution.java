// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        if(S.length()==0)   return 1;
        Stack<Character> stk = new Stack<>();

        char[] chars = S.toCharArray();

        for(char c : chars){
            if(c=='(')  stk.push('(');
            else if(c=='{') stk.push('{');
            else if(c=='[')  stk.push('[');
            else if(c==')' && !stk.isEmpty() && stk.peek()=='('){
                stk.pop();
            }
            else if(c=='}' && !stk.isEmpty() && stk.peek()=='{'){
                stk.pop();
            }
            else if(c==']' && !stk.isEmpty() && stk.peek()=='['){
                stk.pop();
            }
            else return 0;
        }

        if(!stk.isEmpty())  return 0;
        return 1;

    }
}