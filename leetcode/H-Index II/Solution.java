class Solution {
    public int hIndex(int[] citations) {
        int answer = 0;
        int left = 0;
        int right = citations[citations.length-1];

        while(left <= right) {
            int mid = (left + right) / 2;
            if(check(citations,mid) >= mid){
                answer = mid;
                left = mid + 1;
            }
            else    right = mid - 1;
        }

        return answer;
    }

    private int check(int[] citations, int mid) {
        int cnt = 0;
        for(int i=0; i<citations.length; i++) {
            if(citations[i] >= mid) cnt++;
        }
        return cnt;
    }
}