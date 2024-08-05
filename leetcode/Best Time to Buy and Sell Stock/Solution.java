import java.io.*;
import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int std = 0;
        for(int i = prices.length-1; i>=0; i--){
            if(prices[i] > std){
                std = prices[i];
            }
            else{
                answer = Math.max(answer, std - prices[i]);
            }
        }

        return answer;
    }
}