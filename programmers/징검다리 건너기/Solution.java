import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

        int left = 1;
        int right = 0;
        for(int s : stones){
            right = Math.max(right,s);
        }

        while(left<=right){
            //mid명만큼 지나간다.
            int mid = (left + right)/2;

            int len = 0;
            int maxLen = 0;

            for(int i=0; i<stones.length; i++){
                //mid명이 지나갔을 때 사라지는 돌의 길이 계산
                if(stones[i] - mid < 0){
                    len++;
                    maxLen = Math.max(maxLen,len);
                }
                else    len = 0;
            }
            //연속으로 없는 돌의 길이가 점프 할 수 있는 유효 거리인지 확인
            //k만큼 점프할 수 있다는 뜻은 k-1개 이하만큼 돌이 없을 경우 가능
            if(maxLen < k){
                answer = mid;
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }
        return answer;
    }
}