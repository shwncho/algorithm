import java.util.*;
class Solution {
    public String reversePrefix(String s, int k) {
        String reverse = s.substring(0,k);
        StringBuilder sb = new StringBuilder(reverse);
        return sb.reverse().toString() + s.substring(k);
    }
}