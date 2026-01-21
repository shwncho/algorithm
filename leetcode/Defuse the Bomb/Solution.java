class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;

        int[] answer = new int[n];

        if(k==0){
            return answer;
        }

        int left = (k>0) ? 1 : n+k;
        int right = (k>0) ? k : n-1;

        int sum = 0;
        for(int i=left; i<=right; i++) {
            sum+=code[i];
        }

        for(int i=0; i<n; i++) {
            answer[i] = sum;
            sum -= code[(left+i)%n];
            sum += code[(right+i+1)%n];
        }

        return answer;

    }
}