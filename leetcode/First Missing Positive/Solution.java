class Solution {
    public int firstMissingPositive(int[] nums) {
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            max = Math.max(max, n);
            set.add(n);
        }


        int tmp = 1;
        while(max-->0) {
            if(!set.contains(tmp))  return tmp;
            tmp++;
        }

        return tmp;
    }
}