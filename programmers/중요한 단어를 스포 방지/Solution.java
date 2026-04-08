import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        Set<String> set = new HashSet<>();

        StringBuilder blind = new StringBuilder(message);

        for(int[] range : spoiler_ranges) {
            for(int idx = range[0]; idx<=range[1]; idx++) {
                if(blind.charAt(idx)!= ' ') {
                    blind.setCharAt(idx, '*');
                }
            }
        }

        for(String banned : blind.toString().split(" ")) {
            set.add(banned);
        }

        for(String word : message.split(" ")) {
            if(!set.contains(word)) {
                answer++;
                set.add(word);
            }
        }

        return answer;
    }
}