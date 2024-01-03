import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;

        String[] alphabetics = {"zero", "one", "two", "three","four","five","six","seven","eight","nine"};
        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};

        for(int i=0; i<alphabetics.length; i++){
            s=s.replaceAll(alphabetics[i],numbers[i]);
        }

        answer = Integer.parseInt(s);
        return answer;
    }
}