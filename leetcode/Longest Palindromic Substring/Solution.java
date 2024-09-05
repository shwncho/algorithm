import java.util.*;
class Solution {
    public String longestPalindrome(String s) {
        String maxStr = s.substring(0,1);
        for(int i=0; i<s.length()-1; i++){
            String odd = checkPalindrome(s,i,i);
            String even = checkPalindrome(s,i,i+1);

            if(odd.length() > maxStr.length())  maxStr = odd;
            if(even.length() > maxStr.length()) maxStr = even;
        }

        return maxStr;
    }

    private static String checkPalindrome(String str, int start, int end){
        while(start>=0 && end<str.length() && str.charAt(start)==str.charAt(end)){
            start--;
            end++;
        }
        return str.substring(start+1, end);
    }
}