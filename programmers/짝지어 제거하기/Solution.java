import java.util.*;
class Solution
{
    public int solution(String s)
    {

        Stack<Character> stk = new Stack<>();

        for(char c : s.toCharArray()){
            if(stk.isEmpty() || c!=stk.peek())  stk.push(c);
            else    stk.pop();
        }

        return stk.isEmpty() ? 1 : 0;
    }
}