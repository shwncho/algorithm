import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i=0; i<clothes.length; i++){
            set.add(clothes[i][1]);
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }

        // 경우의 수
        // 종류별 옷 중 1개를 입을 경우 + 옷을 안입을 경우
        int value = 1;
        for(String s : set){
            value *= map.get(s)+1;
        }
        // 아무것도 안입을 경우는 -1
        answer = value - 1;

        return answer;
    }
}