class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        int cnt = 0;

        for(char c : s.toCharArray()) {
            if(c=='(') {
                if(cnt > 0) sb.append('(');
                cnt++;
            }

            else if(c == ')') {
                cnt--;
                if(cnt > 0) sb.append(')');
            }
        }

        return sb.toString();
    }
}