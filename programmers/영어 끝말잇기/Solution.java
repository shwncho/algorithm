import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        ArrayList<String> list = new ArrayList<>();
        //이전에 등장한 단어 사용 x => list에 담아서 체크
        // 참가자 본인 차례 체크하는 변수

        list.add(words[0]);
        //단어 배열의 길이만큼 반복
        for(int i=1; i<words.length; i++){
            String s = words[i];
            //이미 답한 단어인지, 끝말이어지는지 체크
            if(list.contains(s) || !check(words[i-1],words[i])){
                answer[0]=(i+1)%n;
                answer[0]=answer[0]==0 ? n : answer[0];
                answer[1]=(i/n)+1;
                break;
            }
            list.add(s);

        }
        return answer;
    }

    public boolean check(String front, String end){
        return front.substring(front.length() - 1)
                .equals(end.substring(0, 1));
    }
}
