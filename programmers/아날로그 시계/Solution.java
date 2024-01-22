import java.util.*;

/**
 * 1. 시간을 초로 변환
 * 2. 시침, 분침, 초침별로 시간별 각도 계산
 * 3. 시작 시간부터 겹치는 경우, 정각이 되는 경우, 각도의 변화를 통해 겹친 경우를 찾는 것 고려
 */
class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        //주어진 시간들을 전부 초로 변환
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        //만약 0시 or 12시가 시작인 경우 겹치는 횟수 1개 추가
        if(start == 0 || start == 43200)    answer++;

        for(int i=start; i<end; i++){


            int currentHour = i / 3600;
            int currentMinute = (i % 3600) / 60;
            int currentSeconds = (i % 3600) % 60;

            //시침 : 1시간 -> 30", 1분 -> 0.5", 1초 -> 1/120"
            //분침 : 1분 -> 6", 1초 -> 0.1"
            //초침 : 1초 -> 6"
            //1시나 13시나 각도가 같기 때문에 모듈러 12 진행
            double currentHourDegree = (currentHour%12) * 30d + currentMinute * 0.5d + currentSeconds * (1/120d);
            double currentMinuteDegree = currentMinute * 6d + currentSeconds * 0.1d;
            double currentSecondsDegree = currentSeconds * 6d;

            int next = i + 1;
            int nextHour = next / 3600;
            int nextMinute = (next % 3600) / 60;
            int nextSeconds = (next % 3600) % 60;

            double nextHourDegree = (nextHour % 12) * 30d + nextMinute * 0.5d + nextSeconds * (1/120d);
            double nextMinuteDegree = nextMinute * 6d + nextSeconds * 0.1d;
            double nextSecondsDegree = nextSeconds * 6d;

            //60초, 60분, 12시 정각이 되는 경우 고려
            if(nextHourDegree == 0) nextHourDegree = 360;
            if(nextMinuteDegree == 0)   nextMinuteDegree = 360;
            if(nextSecondsDegree == 0)  nextSecondsDegree = 360;

            // 시침과 분침과 초침이 전부 겹치면 알림 1회만 울리는 경우
            if(nextHourDegree == nextSecondsDegree && nextMinuteDegree == nextSecondsDegree){
                answer++;
                continue;
            }
            // 초침이 시침보다 각도가 낮았는데 같거나 높아졌을경우
            if(currentHourDegree > currentSecondsDegree && nextHourDegree <= nextSecondsDegree) answer++;
            // 분침이 시침보다 각도가 낮았는데 같거나 높아졌을경우
            if(currentMinuteDegree > currentSecondsDegree && nextMinuteDegree <= nextSecondsDegree) answer++;

        }
        return answer;
    }
}