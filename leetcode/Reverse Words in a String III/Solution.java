class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<strs.length; i++) {
            sb.append(new StringBuilder(strs[i]).reverse());
            if(i!=strs.length-1) sb.append(" ");
        }

        return sb.toString();
    }
}