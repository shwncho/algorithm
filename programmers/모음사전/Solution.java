class Solution {
    public int solution(String word) {
        int answer = word.length();

        //f(x) = f(x-1) + 5^x 로 계산
        int[] a = {781,156,31,6,1};
        String str = "AEIOU";

        for(int i=0; i<word.length(); i++){
            answer+=(a[i]*str.indexOf(word.charAt(i)));
        }
        return answer;
    }
}