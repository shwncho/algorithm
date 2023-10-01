import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        //한 방향으로 쭉 움직였을 때 최소 움직임 값
        int move = name.length() - 1;
        for(int i=0; i<name.length(); i++){
            //위, 아래 움직임의 최소
            answer += Math.min(name.charAt(i) - 'A', 26-(name.charAt(i)-'A'));
            //다음 문자가 'A'인지 체크 + 마지막 'A' 위치 찾기
            if(i < name.length()-1 && name.charAt(i+1)=='A'){
                int endA = i+1;
                while(endA < name.length() && name.charAt(endA)=='A')   endA++;
                //오른쪽으로 갔다가 왼쪽으로 돌아가는 경우
                move = Math.min(move, (i*2)+name.length()-endA);
                //왼쪽으로 갔다가 오른쪽으로 돌아가는 경우
                move = Math.min(move, (name.length()-endA)*2+i);
            }
        }

        return answer+move;
    }
}