import java.util.*;
class Solution {
    public String solution(String input_string) {
        String answer = "";

        //존재여부체크
        Set<Character> checkSet = new HashSet<>();

        //중복제거셋
        Set<Character> set = new TreeSet<>();

        char[] arr = input_string.toCharArray();

        char current = ' ';
        for(char c : arr){
            if(c!=current){
                if(checkSet.contains(c)){
                    set.add(c);
                }
                checkSet.add(c);
                current=c;
            }
        }

        for(char c : set){
            answer+=c;
        }

        if(answer.equals(""))   answer="N";
        return answer;
    }
}