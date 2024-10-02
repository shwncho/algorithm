import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder answer = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        int min = Math.min(first.length(), last.length());
        for(int i=0; i<min; i++){
            if(first.charAt(i) != last.charAt(i))   return answer.toString();
            answer.append(first.charAt(i));
        }

        return answer.toString();

    }
}