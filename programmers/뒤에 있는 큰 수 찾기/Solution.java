import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        int n = numbers.length;
        answer = new int[n];
        Stack<Integer> stk = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty()){
                if(stk.peek() > numbers[i]){
                    answer[i]=stk.peek();
                    break;
                }
                else{
                    stk.pop();
                }
            }

            if(stk.isEmpty()){
                answer[i]=-1;
            }
            stk.push(numbers[i]);
        }
        return answer;
    }
}