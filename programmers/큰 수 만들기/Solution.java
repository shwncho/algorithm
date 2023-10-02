import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<number.length(); i++){
            char c = number.charAt(i);
            while(!stk.isEmpty() && stk.peek() < c && k-->0){
                stk.pop();
            }
            stk.push(c);
        }

        //계속 같은 수 일경우 k만큼 제거를 안하므로
        while(k>0){
            stk.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop()+"");
        }
        answer = sb.reverse().toString();

        return answer;
    }
}