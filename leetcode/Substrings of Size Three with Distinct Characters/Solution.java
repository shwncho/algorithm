class Solution {
    public int countGoodSubstrings(String s) {
        int answer = 0;
        Map<Character,Integer> map = new HashMap<>();

        int left = 0;

        for(int right=0; right<s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c,0)+1);

            if(right-left+1 == 3) {
                if(map.size()==3)   answer++;

                int freq = map.get(s.charAt(left));
                if(freq==1) map.remove(s.charAt(left));
                else    map.put(s.charAt(left),freq-1);

                left++;
            }
        }

        return answer;
    }
}