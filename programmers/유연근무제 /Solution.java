class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        //가변적으로 증감시킬 요일 변수
        int tmp = startday;

        //직원 수
        int n = schedules.length;

        for(int i=0; i<n; i++) {

            //성공실패여부
            boolean flag = true;
            //출근 희망 시각 + 10
            int stdTime = schedules[i] + 10;
            if((stdTime % 100)>=60) {
                stdTime = ((stdTime/100)+1)*100 + (stdTime % 100) % 60;
            }
            // 시작요일 초기화
            tmp = startday;
            for(int j=0; j<7; j++) {
                if(tmp == 6) {
                    tmp++;
                    continue;
                }
                else if(tmp == 7) {
                    tmp = 1;
                    continue;
                }

                if(timelogs[i][j] > stdTime) {
                    flag = false;
                    break;
                }

                tmp++;
            }

            if(flag)    answer++;
        }

        return answer;
    }
}