class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        int left = 1;
        int right = 100000;

        while(left<=right) {
            int mid = (left+right)/2;
            if(solve(diffs,times,mid)<=limit){
                answer = mid;
                right = mid -1;
            }
            else left = mid +1;
        }
        return answer;
    }

    private long solve(int[] diffs, int[] times, int level) {
        long result = 0;
        for(int i=0; i<diffs.length; i++) {
            if(diffs[i] <= level)   result+=times[i];
            else result += (long)(times[i] + times[i-1]) *(long)(diffs[i] - level) + times[i];
        }

        return result;
    }
}