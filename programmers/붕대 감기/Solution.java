import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int now = health;
        //마지막 공격받은 시간
        int lastTime = 0;

        for(int[] atk : attacks){

            //초당 회복량 횟수
            int b1 = atk[0] - lastTime - 1;
            //추가 회복량 횟수
            int b2 = b1 / bandage[0];

            now = Math.min(health, now + (b1*bandage[1]) + (b2*bandage[2]));

            lastTime = atk[0];
            now-=atk[1];

            if(now<=0){
                return -1;
            }
        }
        answer = now;
        return answer;
    }
}