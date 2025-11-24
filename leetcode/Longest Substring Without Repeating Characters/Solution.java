class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int left = 0;
        Set<Character> charSet = new HashSet<>();

        for(int right = 0; right<s.length(); right++) {
            while(charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            answer = Math.max(answer, right - left + 1);
        }


        return answer;
        // 기존 풀이
        // int answer = 0;
        // int cnt = 0;
        // int[] frq = new int[126];

        // int left = 0;
        // for(int right = 0; right<s.length();  right++) {
        //     frq[s.charAt(right)-' ']++;
        //     if(frq[s.charAt(right)-' '] == 1){
        //         cnt++;
        //     }    
        //     else {
        //         while(frq[s.charAt(right)-' ']!=1) {
        //             frq[s.charAt(left)-' ']--;
        //             if(frq[s.charAt(left)-' ']==0) cnt--;
        //             left++;
        //         }

        //     }
        //     answer = Math.max(answer, cnt);
        // }



        // return answer;
    }
}