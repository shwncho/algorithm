import java.util.*;
class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;

        int left = 1;
        //전체 경우의 수에서 가장 오래걸리는 시간
        int right = Arrays.stream(cores).max().getAsInt() * n;
        int time = 0;
        while(left<=right){
            int mid = (left + right)/2;
            //조건을 만족하는 값 중 가장 작은 mid를 찾아야 하기 때문에 right 기준
            if(check(mid,cores)>=n){
                time = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        //핵심 로직 1 (목표 시간 - 1초 까지 몇 개의 작업을 처리할 수 있는지)
        for(int i=0; i<cores.length; i++){
            n-=(time-1)/cores[i]+1;
        }

        //핵심 로직 2 ( 목표 시간이 되었을 때 나누어 떨어지면 빈 코어라는 뜻)
        for(int i=0; i<cores.length; i++){
            if(time % cores[i] == 0)    n--;
            if(n==0){
                answer = i+1;
                break;
            }
        }

        return answer;
    }

    private int check(int mid, int[] arr){
        int cnt = 0;
        //1을 더해주는 것은 0초에 core 개수만큼 적재할 수 있는 것
        for(int i=0; i<arr.length; i++){
            cnt+=mid/arr[i] + 1;
        }
        return cnt;
    }
}