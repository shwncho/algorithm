class Solution {
    public int maxProfit(int[] prices, int fee) {
        // 구매에 지불한 금액
        int buy = Integer.MIN_VALUE;
        // 벌어들인 금액
        int profit = 0;

        for(int price : prices) {
            // 지불한 금액은 음수로 계산하므로 값이 클 수록 돈을 덜 쓴 것
            buy = Math.max(buy, profit - price);
            // 지금까지 벌어들인 금액과 (구매할 때 지불한 금액 + 판매한 시점 - 수수료)를 비교
            profit = Math.max(profit, buy + price - fee);
        }

        return profit;
    }
}