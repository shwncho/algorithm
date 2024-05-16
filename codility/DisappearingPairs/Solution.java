// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String S) {

        String answer = "";
        Stack<Character> stk = new Stack<>();

        char[] chars = S.toCharArray();
        for(char c : chars){
            if(!stk.isEmpty()){
                if(stk.peek()==c)   stk.pop();
                else    stk.push(c);
            }
            else    stk.push(c);
        }
        StringBuilder sb = new StringBuilder();
        if(!stk.isEmpty()){
            for(char c : stk){
                sb.append(c);
            }
            answer = sb.toString();
        }


        return answer;
    }
}