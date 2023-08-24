import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[] terms = {"RT","CF","JM","AN"};
        int[] scores = {0,3,2,1,0,1,2,3};

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<4; i++){
            String str = terms[i];
            String s1 = str.substring(0,1);
            String s2 = str.substring(1,2);

            map.put(s1,0);
            map.put(s2,0);
        }

        for(int i=0; i<survey.length; i++){
            int num = choices[i];

            if(num == 4)    continue;

            if(num<=3){
                String s = survey[i].substring(0,1);
                int n=scores[num];

                map.put(s,map.get(s)+n);
            }
            else{
                String s = survey[i].substring(1,2);
                int n=scores[num];

                map.put(s,map.get(s)+n);
            }
        }

        for(int i=0; i<4; i++){
            String str = terms[i];
            String s1 = str.substring(0,1);
            String s2 = str.substring(1,2);

            if(map.get(s1) > map.get(s2))   answer+=s1;
            else if(map.get(s1) == map.get(s2)){
                if(s1.compareTo(s2) <0) answer+=s1;
                else    answer+=s2;
            }
            else    answer+=s2;
        }


        return answer;
    }
}