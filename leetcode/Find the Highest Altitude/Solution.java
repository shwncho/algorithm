class Solution {
    public int largestAltitude(int[] gain) {
        int[] sum = new int[gain.length+1];
        int answer = 0;

        for(int i=1; i<=gain.length; i++){
            sum[i] = sum[i-1] + gain[i-1];
            answer = Math.max(answer, sum[i]);
        }

        return answer;
    }
}