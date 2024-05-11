import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (o1,o2) -> (o1[1] - o2[1]));

        int prev = routes[0][1];
        for(int[] r : routes){
            if(r[0]>prev){
                answer++;
                prev=r[1];
            }
        }

        return answer;
    }
}