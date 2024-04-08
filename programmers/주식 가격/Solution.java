import java.util.*;
class Solution {

    static class Stock{
        public int value, idx;
        Stock(int value, int idx){
            this.value = value;
            this.idx = idx;
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Stock> stk = new Stack<>();

        for(int i=0; i<prices.length; i++){

            while(!stk.isEmpty() && stk.peek().value > prices[i]){
                Stock tmp = stk.pop();
                if(tmp.value > prices[i]){
                    answer[tmp.idx] = i-tmp.idx;
                }
                else{
                    stk.push(tmp);
                    break;
                }
            }

            stk.push(new Stock(prices[i],i));
        }

        for(Stock s : stk){
            answer[s.idx] = prices.length-1-s.idx;
        }

        return answer;
    }
}