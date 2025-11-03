class Solution {
    public int hIndex(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        //0,1,3,5,6
        int tmp = 0;
        for(int i=0; i<citations.length; i++) {
            tmp = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, tmp);
        }


        return answer;
    }
}