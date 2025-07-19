class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] answer = new int[temperatures.length];
        stk.push(0);
        for(int i=1; i<temperatures.length; i++){
            while(!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]){
                int idx = stk.pop();
                answer[idx] = i - idx;
            }
            stk.push(i);
        }
        return answer;
    }
}