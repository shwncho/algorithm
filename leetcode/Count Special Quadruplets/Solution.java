class Solution {
    public int countQuadruplets(int[] nums) {
        int answer = 0;

        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int a = 0; a <n-3; a++) {
            for(int b = a+1; b<n-2; b++) {
                int sum = nums[a] + nums[b];
                List<Integer> list = map.getOrDefault(sum, new ArrayList<>());
                map.put(sum,list);
                list.add(b);
            }
        }

        for(int d = n-1; d>2; d--) {
            for(int c = d-1; c>1; c--) {
                int sum = nums[d] - nums[c];
                if(map.containsKey(sum)){
                    List<Integer> list = map.get(sum);
                    for(int i : list)   if(i < c)   answer++;
                }
            }
        }

        return answer;
    }
}