import java.util.*;
class Solution {
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int left=0, right=s.length()-1;

        while(left < right){
            while((left < right) && vowels.indexOf(word[left])==-1) {
                left++;
            }

            while((left < right) && vowels.indexOf(word[right])==-1) {
                right--;
            }

            char tmp = word[left];
            word[left] = word[right];
            word[right] = tmp;

            left++;
            right--;
        }

        return new String(word);
    }
}