import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;

        //유사도 -> 교집합 / 합집합, 두 집합이 모두 공집합이면 유사도 1

        //2글자씩 끊기
        List<String> strList1 = new ArrayList<>();
        List<String> strList2 = new ArrayList<>();

        for(int i=0; i<str1.length()-1; i++){
            strList1.add(str1.substring(i,i+1)+str1.substring(i+1,i+2));
        }

        for(int i=0; i<str2.length()-1; i++){
            strList2.add(str2.substring(i,i+1)+str2.substring(i+1,i+2));
        }

        List<String> updateList1 = new ArrayList<>();
        List<String> updateList2 = new ArrayList<>();
        //문자 외 제거
        for(int i=0; i<strList1.size(); i++){
            char[] chars = strList1.get(i).toCharArray();
            String s = "";
            for(int j=0; j<chars.length; j++){
                if(Character.isAlphabetic(chars[j]))   s+=String.valueOf(chars[j]).toLowerCase();
            }
            if(s.length()==2) updateList1.add(s);
        }

        for(int i=0; i<strList2.size(); i++){
            char[] chars = strList2.get(i).toCharArray();
            String s = "";
            for(int j=0; j<chars.length; j++){
                if(Character.isAlphabetic(chars[j]))   s+=String.valueOf(chars[j]).toLowerCase();
            }
            if(s.length()==2)   updateList2.add(s);

        }


        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        //교집합 구하는 로직
        int common = 0;
        for(String tmp : updateList1){
            map1.put(tmp,map1.getOrDefault(tmp,0)+1);
        }

        for(String tmp : updateList2){
            map2.put(tmp,map2.getOrDefault(tmp,0)+1);
        }

        for(String tmp : map1.keySet()){
            if(map2.containsKey(tmp))    common+=Math.min(map1.get(tmp),map2.get(tmp));
        }

        //합집합 구하는 로직
        int all = 0;
        Set<String> set = new HashSet<>();
        for(String tmp : map1.keySet()){
            if(map2.containsKey(tmp) && !set.contains(tmp)){
                all+=Math.max(map1.get(tmp),map2.get(tmp));
                //중복 계산 방지
                set.add(tmp);
            }
            else{
                all+=map1.get(tmp);
            }
        }


        for(String tmp : map2.keySet()){
            if(!map1.containsKey(tmp))    all+=map2.get(tmp);
        }

        if(common==0 && all==0) return 65536;

        answer = (double)common / all;
        return (int)(answer*65536);
    }
}