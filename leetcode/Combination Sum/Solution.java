class Solution {
    private List<List<Integer>> answer = new ArrayList<>();
    private void DFS(int[] nums, int target, int s, int sum, List<Integer> tmpList) {
        if(target<sum)  return;
        if(target == sum)   {
            answer.add(new ArrayList<>(tmpList));
            return;
        }

        for(int i=s; i<nums.length; i++) {
            tmpList.add(nums[i]);
            DFS(nums,target,i,sum+nums[i],tmpList);
            tmpList.remove(tmpList.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        DFS(candidates, target, 0,0,new ArrayList<>());
        return answer;
    }
}