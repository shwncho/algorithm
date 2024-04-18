// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] H) {
        // Implement your solution here
        int answer = 1;
        Stack<Integer> stk = new Stack<>();
        stk.push(H[0]);
        for(int i=1; i<H.length; i++){
            if(stk.peek() == H[i])  continue;
            else if(stk.peek()<H[i]){
                stk.push(H[i]);
                answer++;
            }
            else{
                while(!stk.isEmpty() && stk.peek()>H[i]){
                    stk.pop();
                }
                if(stk.isEmpty() || stk.peek() < H[i]){
                    answer++;
                    stk.push(H[i]);
                }
            }
        }
        return answer;
    }
}