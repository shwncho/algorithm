import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);
        //출발 지점으로부터 바위의 최소거리 1, 최대거리 distance
        int left = 1;
        int right = distance;

        // left, right는 index개념이 아닌 값을 찾기 위한 용도이므로 부등호 같게 해줘서
        // 9//2 = 4, 10//2 = 5 와 같이 둘 다 성립가능할 경우 최대값을 찾아야 하므로 
        while(left<=right){
            int mid = (left + right) / 2;

            if(checkRockCnt(mid, rocks, distance)<=n){
                answer = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return answer;
    }

    public static int checkRockCnt(int mid, int[] rocks, int distance){
        int prev=0;
        int removedRockCnt = 0;
        for(int i=0; i<rocks.length; i++){
            if(rocks[i] - prev < mid)   removedRockCnt++;
            else    prev = rocks[i];
        }

        //마지막 지점비교
        if(distance - prev < mid)  removedRockCnt++;

        return removedRockCnt;
    }
}