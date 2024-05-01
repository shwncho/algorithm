import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        //첫번째 구간의 왼쪽 확인
        int tmp = stations[0]-w-1;
        if(tmp>0)   list.add(tmp);

        //두번째 부터 맨 끝 기지국의 왼쪽 부분 확인
        for(int i=1; i<stations.length; i++){
            int cnt = stations[i]-w*2-stations[i-1]-1;
            if(cnt>0)   list.add(cnt);
        }

        //마지막 기지국의 오른쪽 확인
        if(stations[stations.length-1]<n){
            int cnt = n-stations[stations.length-1]-w;
            if(cnt>0) list.add(cnt);
        }

        //확인된 기지국들 사이의 전파 안된 공간을 계산
        for(int value : list){
            if(value<w*2+1) answer++;
            else{
                if(value%(w*2+1)==0)  answer+=value/(w*2+1);
                else    answer+=value/(w*2+1)+1;
            }

        }

        return answer;
    }
}