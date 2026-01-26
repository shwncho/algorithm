class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int left = 0;
        int answer = 0;

        int zeroCnt = 0;
        int oneCnt = 0;

        for(int right = 0; right<s.length(); right++) {
            if(s.charAt(right)=='0'){
                zeroCnt++;
            }
            else    oneCnt++;

            while(zeroCnt > k && oneCnt > k) {
                if(s.charAt(left)=='0') zeroCnt--;
                else    oneCnt--;

                left++;
            }

            answer += right - left + 1;
        }

        return answer;
    }
}