class Solution {
    private List<List<Integer>> answer = new ArrayList<>();
    private void DFS(int s, int sum, int[] nums, int target,List<Integer> tmpList) {
        if(sum>target)  return;
        if(sum == target) {
            answer.add(new ArrayList<>(tmpList));
            return;
        }

        for(int i=s; i<nums.length; i++){
            if(i>s && nums[i] == nums[i-1]) continue;
            tmpList.add(nums[i]);
            DFS(i+1,sum+nums[i],nums,target,tmpList);
            tmpList.remove(tmpList.size()-1);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        DFS(0,0,candidates,target,new ArrayList<>());
        return answer;
    }
}