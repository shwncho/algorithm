import java.util.*;
class Solution {
    public int solution(String[] strs, String t) {

        //최소 타이핑 회수 저장
        int[] dp = new int[t.length()+1];
        Arrays.fill(dp, 100_000_000);
        //시작 위치는 0회
        dp[0]=0;

        //목표 문자열을 순회하면서 최소 타이핑 횟수 찾기
        for(int i=1; i<=t.length(); i++){
            for(String str : strs){
                //현재 인덱스 위치에 맞는 문자열의 길이별로 갱신
                //목표 문자열로 시작하는지 체크
                if(i>=str.length() && t.startsWith(str,i-str.length())){
                    dp[i] = Math.min(dp[i], dp[i-str.length()]+1);
                }
            }
        }

        return dp[t.length()] == 100_000_000 ? -1 : dp[t.length()];

    }
}