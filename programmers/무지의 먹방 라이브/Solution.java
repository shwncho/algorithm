import java.util.*;
class Solution {

    static class Food{
        public int num, time;
        Food(int num, int time){
            this.num = num;
            this.time = time;
        }
    }

    public long solution(int[] food_times, long k) {
        long answer = 0;

        List<Food> list = new ArrayList<>();

        long sum = 0;
        for(int i=0; i<food_times.length; i++){
            list.add(new Food(i+1,food_times[i]));
            sum+=food_times[i];
        }

        if(sum<=k)   return -1;

        Collections.sort(list, (o1,o2) -> (o1.time - o2.time));

        long sumTime = 0;
        int lastIdx = 0;
        long prevSumTime = 0;

        for(int i=0; i<list.size(); i++){
            //연산의 결과가 int를 벗어날 수 있으므로 long으로 캐스팅 해서 계산 or 변수 자체를 long으로 선언 -> 이 부분 놓쳐서 오래 잡아먹음
            //결론: 딱 맞게 범위 설정보다 여유있게 설정하는게 좋을 듯
            if(i == 0)  sumTime += (long)list.get(0).time * list.size();
            else{
                sumTime += (long)(list.get(i).time - list.get(i-1).time) * (list.size()-i);
            }

            if(sumTime > k){
                lastIdx = i;
                break;
            }
            else prevSumTime = sumTime;
        }

        List<Food> result = new ArrayList<>();
        for(int i=lastIdx; i<list.size(); i++)  result.add(list.get(i));
        Collections.sort(result, (o1,o2) -> (o1.num - o2.num));
        long remainTime = k - prevSumTime;

        long idx = remainTime % result.size();
        answer = result.get((int)idx).num;
        return answer;
    }
}