class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        long priceSum = 0;
        for(int i=1; i<=count; i++){
            priceSum += price * i;
        }

        if(money<priceSum)  answer = priceSum - money;

        return answer;
    }
}