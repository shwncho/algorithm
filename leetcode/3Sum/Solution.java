class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            //중복 요소 생략
            if(i>0 && nums[i] == nums[i-1]) continue;
            //양수들만 있으면 0이 안나오므로 종료
            if(nums[i] >0)  break;

            int left = i+1, right = nums.length-1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum==0) {
                    answer.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;

                    //중복되는 요소 스킵
                    while(left<right && nums[left] == nums[left-1]) left++;
                    while(left<right && nums[right] == nums[right+1])   right--;
                }
                else if(sum < 0)    left++;
                else    right--;
            }
        }


        return answer;
    }
}