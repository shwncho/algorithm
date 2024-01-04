import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        if(p.equals(""))    return "";

        String u = "";
        String v = "";
        int left = 0;
        int right = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='(') left++;
            else    right++;

            if(left==right){
                u = p.substring(0,i+1);
                v = p.substring(i+1);
                break;
            }
        }

        if(isRight(u))  answer = u+solution(v);
        else{

            u = u.substring(1,u.length()-1);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<u.length(); i++){
                if(u.charAt(i)=='(')    sb.append(")");
                else    sb.append("(");
            }

            u=sb.toString();

            answer = "(" + solution(v) + ")" + u;
        }

        return answer;
    }

    public static boolean isRight(String s){
        Stack<Character> stk = new Stack<>();
        if(s.charAt(0)==')')    return false;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(')    stk.push('(');
            else{
                if(stk.isEmpty())   return false;
                else    stk.pop();
            }
        }

        return stk.isEmpty();

    }
}