class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())    return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(char c : word1.toCharArray()) map1.put(c,map1.getOrDefault(c,0)+1);
        for(char c : word2.toCharArray()) map2.put(c,map2.getOrDefault(c,0)+1);

        //비교대상이 없을경우
        for(char c : map1.keySet()){
            if(!map2.containsKey(c))    return false;
        }

        Map<Integer,Integer> s1 = new HashMap<>();
        Map<Integer,Integer> s2 = new HashMap<>();

        for(char c : map1.keySet()){
            int num = map1.get(c);
            s1.put(num,s1.getOrDefault(num,0)+1);
        }

        for(char c : map2.keySet()){
            int num = map2.get(c);
            s2.put(num,s2.getOrDefault(num,0)+1);
        }

        //문자별 개수가 다를 경우
        for(int i : s1.keySet()){
            if(s1.get(i) != s2.get(i))  return false;
        }
        return true;

    }
}