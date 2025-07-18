class Solution {
    private void DFS(int L, StringBuilder sb, String digits, String[] phoneNumber, List<String> answer) {
        if(L==digits.length())    answer.add(sb.toString());
        else{
            String letters = phoneNumber[digits.charAt(L)-'2'];
            for(char letter : letters.toCharArray()){
                sb.append(letter);
                DFS(L+1,sb,digits,phoneNumber,answer);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())    return Collections.emptyList();

        String[] phoneNumber = {
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        List<String> answer = new ArrayList<>();
        DFS(0,new StringBuilder(),digits,phoneNumber,answer);
        return answer;
    }
}