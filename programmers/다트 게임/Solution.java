import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] result = new int[3];

        char[] dart = dartResult.toCharArray();

        int len = dart.length;
        int idx = 0;
        int cnt = -1;

        for(int i=0; i<len; i++){
            if(Character.isDigit(dart[i]) && !Character.isDigit(dart[i+1])){
                cnt++;
                result[cnt]=dart[i] -'0';

            }
            else if(Character.isDigit(dart[i]) && Character.isDigit(dart[i+1])){
                cnt++;
                i++;
                result[cnt]=10;
            }
            //보너스
            else if(Character.isLetter(dart[i])){
                if(dart[i]=='D')    result[cnt]=(int)Math.pow(result[cnt],2);
                else if(dart[i]=='T')  result[cnt]=(int)Math.pow(result[cnt],3);
            }
            //옵션
            else{
                if(dart[i]=='*'){
                    if(cnt==0){
                        result[0]=result[0]*2;
                    }
                    else{
                        result[cnt]=result[cnt]*2;
                        result[cnt-1]=result[cnt-1]*2;
                    }
                }
                else if(dart[i]=='#'){
                    result[cnt]=result[cnt] * (-1);
                }
            }
        }

        for(int value : result) answer+=value;

        return answer;
    }
}