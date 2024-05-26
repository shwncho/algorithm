import java.util.*;
class Solution {
    public int solution(int N, int number) {
        //핵심 로직
        //dp[i] = dp[i-j] (사칙연산) dp[j]로 갱신
        List<Set<Integer>> countList = new ArrayList<>();

        for(int i=0; i<9; i++)  countList.add(new HashSet<>());

        //사칙연산을 제외하고 N을 i개로 만들 수 있는 경우 포함
        int tmp = 0;
        for(int i=1; i<9; i++){
            tmp = tmp * 10 + N;
            countList.get(i).add(tmp);
        }


        for(int i=2; i<9; i++){
            for(int j=1; j<=i; j++){
                Set<Integer> preSet = countList.get(j);
                Set<Integer> postSet = countList.get(i-j);
                for(int preNum : preSet){
                    for(int postNum : postSet){
                        countList.get(i).add(preNum + postNum);
                        countList.get(i).add(preNum - postNum);
                        countList.get(i).add(preNum * postNum);

                        if(preNum!=0 && postNum!=0) countList.get(i).add(preNum / postNum);
                    }
                }
            }
        }

        for(int i=1; i<9; i++){
            if(countList.get(i).contains(number))   return i;
        }

        return -1;
    }
}