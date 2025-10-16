class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] result;
        Stack<Integer> stk = new Stack<>();

        for(int num : asteroids) {
            if(num > 0) stk.push(num);
            else {
                while(!stk.isEmpty() && stk.peek() >0 && stk.peek() < Math.abs(num)) stk.pop();

                if(stk.isEmpty() || stk.peek() < 0) stk.push(num);

                if(stk.peek() == Math.abs(num)) stk.pop();
            }
        }

        int n = stk.size();
        result = new int[n];
        while(!stk.isEmpty()){
            result[--n] = stk.pop();
        }

        return result;
    }
}