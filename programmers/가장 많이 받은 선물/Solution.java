import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;


        int n = friends.length;
        //이름별 인덱스
        Map<String, Integer> nameIdx = new HashMap<>();
        for(int i=0; i<n; i++){
            String name = friends[i];
            nameIdx.put(name,i);
        }

        //주고받은기록
        int[][] records = new int[n][n];
        for(String s : gifts){
            String from = s.split(" ")[0];
            String to = s.split(" ")[1];

            records[nameIdx.get(from)][nameIdx.get(to)]++;
        }
        //선물지수
        int[] presentScore = new int[n];
        for(int i=0; i<n; i++){

            int give = 0;
            for(int j=0; j<n; j++){
                if(i==j)    continue;

                give+=records[i][j];
            }

            int given =0 ;
            for(int j=0; j<n; j++){
                if(i==j)    continue;

                given+=records[j][i];
            }
            presentScore[i]=give-given;
        }

        //다음달 받는 수
        int[] next = new int[n];

        for(int i=0; i<n; i++){
            int num = 0;
            for(int j=0; j<n; j++){
                if(i==j)    continue;

                if(records[i][j] > records[j][i])   num++;
                else if(records[i][j]==records[j][i]){
                    if(presentScore[i]>presentScore[j])   num++;
                }
            }
            next[i]=num;
        }

        for(int i=0; i<n; i++){
            answer = Math.max(answer, next[i]);
        }


        return answer;
    }
}