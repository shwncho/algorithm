class Solution {
    public int solution(int[] citations) {
        int answer = 0;


        for(int i=0; i<=10000; i++){
            int std = i;
            int cnt=0;
            for(int j=0; j<citations.length; j++){
                if(citations[j]>=std)   cnt++;
            }

            if(cnt>=std){
                answer=Math.max(answer,std);
            }
        }
        return answer;
    }
}