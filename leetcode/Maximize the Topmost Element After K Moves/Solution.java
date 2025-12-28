class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        int max = -1;

        //원소가 1개일 때, 홀수면 -1, 짝수면 그대로 리턴
        if(n==1){
            if(k%2==1)  return -1;
            else    return nums[0];
        }

        // k가 n보다 작으면 k번째 원소까지 가장 큰 값을
        if(k<n) max = nums[k];
            //k가 n보다 크면 전체 원소중 가장 큰 값을
        else if(k>n)    k = n+1;

        // 왜 k-1번째까지? ->  k-1번까지 pop 가능, 마지막 1번은 push 가능
        for (int i = 0; i < k-1; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}