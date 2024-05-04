// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        Stack<Character> stk = new Stack<>();

        char[] chars = S.toCharArray();

        for(char c : chars){
            if(c=='(')  stk.push(c);
            else{
                if(stk.isEmpty()){
                    return 0;
                }
                stk.pop();
            }
        }

        if(!stk.isEmpty())  return 0;
        return 1;
    }
}
