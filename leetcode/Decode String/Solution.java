class Solution {
    public String decodeString(String s) {
        Stack<Character> stk = new Stack<>();

        for(char c : s.toCharArray()){
            if(c!=']')  stk.push(c);
            else {
                StringBuilder alphabet = new StringBuilder();
                StringBuilder numbers = new StringBuilder();
                //문자 추출
                while(!stk.isEmpty() && stk.peek() != '[') alphabet.append(String.valueOf(stk.pop()));
                stk.pop();
                //숫자 추출
                while(!stk.isEmpty() && Character.isDigit(stk.peek()))
                    numbers.append(stk.pop() - '0');
                int k = Integer.parseInt(numbers.reverse().toString());

                String str = alphabet.reverse().toString();
                for(int i=0; i<k; i++){
                    for(char t : str.toCharArray()) stk.push(t);
                }

            }
        }
        StringBuilder answer = new StringBuilder();
        while(!stk.isEmpty())   answer.insert(0,String.valueOf(stk.pop()));
        return answer.toString();
    }
}