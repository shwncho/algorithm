class Solution {
    public int longestConsecutive(int[] nums) {
        int answer = 0;
        Set<Integer> s = new HashSet<>();
        for(int n : nums)   s.add(n);

        for(int n : s) {
            //n-1이 없다는 판단을 통해 겹치는 구간을 skip하여 시간 최적화
            if(!s.contains(n-1)){
                int len = 1;
                while(s.contains(n+len))    len++;

                answer = Math.max(answer, len);
            }
        }

        return answer;
    }
}