class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        for(int i=0; i<s.length()-1; i++){
            answer = Math.max(answer, checkPalindrome(s,i,i));
            answer = Math.max(answer, checkPalindrome(s,i,i+1));
        }

        return answer;
    }
    public static int checkPalindrome(String str, int start, int end){
        while(start>=0 && end<str.length() && str.charAt(start)==str.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
}