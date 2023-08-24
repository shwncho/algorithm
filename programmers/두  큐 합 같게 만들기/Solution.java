import java.util.*;

class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long answer = 0;
        int n = queue1.length;

        Queue<Long> Q1 = new LinkedList<>();
        Queue<Long> Q2 = new LinkedList<>();

        long sum1 = 0L;
        long sum2 = 0L;

        for(int i=0; i<n; i++){
            long num1 = queue1[i];
            long num2 = queue2[i];

            sum1 += num1;
            sum2 += num2;

            Q1.offer(num1);
            Q2.offer(num2);
        }

        // 큐 2개가 아닌 기준을 큐 1개로 두고, (전체 합)/2를 타겟으로 연산 진행
        long target=(sum1+sum2)/2;

        long cnt = 0;
        while(true){

            if(sum1 == target) break;

            if(Q2.isEmpty()){
                cnt = -1;
                break;
            }

            if(sum1>target){
                long tmp = Q1.poll();
                sum1-=tmp;
            }
            else{
                long tmp =Q2.poll();
                Q1.offer(tmp);
                sum1+=tmp;
            }

            cnt++;
        }

        answer = cnt;
        return answer;
    }
}