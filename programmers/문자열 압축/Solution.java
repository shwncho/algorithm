import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=s.length(); i++){
            int cnt = 1;
            String prev = "";
            String tmp="";
            String result="";
            for(int j=0; j+i<=s.length(); j+=i){
                tmp = s.substring(j,j+i);
                if(tmp.equals(prev))    cnt++;
                else if(j!=0 && !tmp.equals(prev)){
                    if(cnt==1){
                        result+=prev;
                    }
                    else{
                        result+=String.valueOf(cnt)+prev;
                        cnt=1;
                    }
                }
                prev=tmp;
            }
            if(cnt==1){
                result+=prev;
            }
            else{
                result+=String.valueOf(cnt)+prev;
                cnt=1;
            }

            result+=s.substring(s.length()-(s.length()%i));

            answer = Math.min(answer, result.length());
        }


        return answer;
    }
}