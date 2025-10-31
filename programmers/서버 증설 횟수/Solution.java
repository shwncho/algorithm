import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        //현재 서버 대수
        int serverCnt = 0;
        //시간별 증설 대수
        int[] install = new int[24];

        for(int i=0; i<24; i++) {
            if(i>=k) {
                serverCnt -= install[i-k];
            }
            //필요한 증설 횟수
            if(serverCnt < players[i] / m){
                int req = players[i] / m - serverCnt;
                answer += req;
                serverCnt += req;
                install[i] = req;
            }

        }

        return answer;
    }

}