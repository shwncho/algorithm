import java.util.*;
class Solution {
    public String removeStars(String s) {
        Stack<String> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            String tmp = s.substring(i,i+1);
            if(!tmp.equals("*"))    stk.push(tmp);
            else{
                stk.pop();
            }
        }

        while(!stk.isEmpty())   sb.append(stk.pop());
        return sb.reverse().toString();
    }
}