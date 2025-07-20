class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) return true;

        int left = 0;
        int right = 0;

        while(right<t.length()){
            if(s.charAt(left) == t.charAt(right)){
                left++;
            }
            if(left>=s.length())    return true;
            right++;
        }

        return false;
    }
}