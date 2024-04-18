import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;

        int cnt1 = 1;
        int cnt2 = 0;
        char x=s.charAt(0);

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==x)  cnt1++;
            else{
                cnt2++;
                if(cnt1==cnt2){
                    answer++;
                    cnt1=0;
                    cnt2=0;
                    if(i<s.length()-1)  x=s.charAt(i+1);
                }
            }
        }

        if(cnt1!=0 || cnt2!=0)  answer++;

        return answer;
    }
}