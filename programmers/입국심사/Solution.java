import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        //찾으려는 최소 시간
        long answer = 0;

        Arrays.sort(times);

        long left = 0;
        //최악의 경우 => 인원 수 * 최대 시간
        //n은 int , 최대값 1,000,000,000 이므로 long으로 변환해서 계산해야 오버플로우 안난다.
        long right = (long)n * times[times.length-1];

        while(left<=right){
            //이분 탐색의 기준 = 시간
            long mid = (left + right) / 2;
            //입국심사시간별 받을 수 있는 사람의 합
            long sum = 0;
            for(int x : times){
                sum+= mid / x;
            }

            if(sum<n){ //검사해야하는 인원이 더 필요한 경우 시간 up
                left=mid+1;
            }
            else{ // 검사해야하는 인원이 n보다 많은경우 down
                right=mid-1;
                answer=mid;
            }
        }
        return answer;

    }

}