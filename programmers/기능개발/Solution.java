import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int n = progresses.length;
        int[] works = new int[n];



        for(int i=0; i<n; i++){
            works[i] = (100 - progresses[i]) / speeds[i];
            if(((100 - progresses[i]) % speeds[i])!=0){
                works[i]+=1;
            }
        }


        //작업들의 종료일수를 한 번에 구한 뒤,
        //이어지는 요소들 간 값 비교를 통해 연속으로 몇 개의 작업을 배포할 수 있는지 계산하는게 핵심
        int prev = works[0];
        int count = 1;
        for(int i=1; i<n; i++){

            if(prev>=works[i])  count++;
            else{
                answer.add(count);
                count=1;
                prev = works[i];
            }
        }
        //마지막 progresses 포함
        answer.add(count);

        return answer;
    }
}