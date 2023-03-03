import java.util.*;
class Solution {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];

        Map<Integer,Integer> xmap = new HashMap<>();
        Map<Integer,Integer> ymap = new HashMap<>();

        for(int i=0; i<v.length; i++){
            xmap.put(v[i][0],xmap.getOrDefault(v[i][0],0)+1);
            ymap.put(v[i][1],ymap.getOrDefault(v[i][1],0)+1);
        }

        for(int i=0; i<v.length; i++){
            if(xmap.get(v[i][0])==1)    answer[0]=v[i][0];
            else if(ymap.get(v[i][1])==1)   answer[1]=v[i][1];
        }
        return answer;
    }
}