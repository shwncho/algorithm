import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        //배달 누적합
        int deliver = 0;
        //수거 누적합
        int pickup = 0;

        for(int i=n-1; i>=0; i--){
            //한 쪽이라도 거칠 곳이 있는지
            if(deliveries[i] != 0 || pickups[i] !=0){
                //몇 번 왕복할 것인지
                int cnt = 0;
                //누적합이 특정 집의 배달량 or 수거량보다 적은지
                //적다면 cap만큼 보충해주기
                while(deliver < deliveries[i] || pickup < pickups[i]){
                    cnt++;
                    deliver += cap;
                    pickup += cap;
                }
                //들린 곳 차감
                deliver-=deliveries[i];
                pickup-=pickups[i];
                answer += (i+1) * cnt * 2;
            }
        }

        return answer;
    }
}