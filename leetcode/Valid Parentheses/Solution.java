class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        char[] chars = s.toCharArray();
        stk.push(chars[0]);

        for(int i=1; i<chars.length; i++) {
            if(!stk.isEmpty()){
                if(stk.peek() == '(' && chars[i] == ')')    stk.pop();
                else if(stk.peek() == '{' && chars[i] == '}') stk.pop();
                else if(stk.peek() == '[' && chars[i] == ']')   stk.pop();
                else stk.push(chars[i]);
            }
            else    stk.push(chars[i]);
        }

        return stk.size() == 0;
    }
}