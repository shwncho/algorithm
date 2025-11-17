class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int std = 0;
        for(int i=prices.length-1; i>=0; i--) {
            if(prices[i] <= std) answer += std - prices[i];
            std = prices[i];
        }

        return answer;
    }
}