class Solution {
    private boolean valid(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c=='u')  return true;
        return false;
    }
    public int maxVowels(String s, int k) {
        int cnt = 0;

        for(int i=0; i<k; i++){
            if(valid(s.charAt(i)))  cnt++;
        }

        int answer = cnt;
        for(int i = k; i < s.length(); i++){
            if(valid(s.charAt(i)))  cnt++;
            if(valid(s.charAt(i-k)))    cnt--;
            answer = Math.max(answer,cnt);
        }

        return answer;
    }
}