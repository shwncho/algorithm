class Solution {
    public int maxPower(String s) {
        if(s.length()==1)   return 1;

        int answer = 1;
        int left = 0;
        char[] tmp = s.toCharArray();
        for(int right=1; right<tmp.length; right++){
            if(tmp[right] != tmp[right-1])  left = right;
            else{
                answer = Math.max(answer , right - left + 1);
            }
        }

        return answer;
    }
}